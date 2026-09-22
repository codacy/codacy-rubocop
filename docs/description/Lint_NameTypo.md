
Checks for probable typos in constant and method names: a name that
does not resolve anywhere in the project, used in a namespace the
project does define, with a close-named sibling to suggest instead.

The check is powered by the project-wide index, so it only runs when
`AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed.
Without the index the cop does nothing.

Constants are checked only in qualified references (`Foo::Bar`) whose
namespace resolves in the index; bare names cannot be distinguished
from constants provided by gems or the standard library. Methods are
checked only in calls on constant receivers (`Foo.bar`) whose entire
indexed ancestry is resolved, so methods gained through gem classes or
dynamic definitions never produce offenses. In both cases an offense
requires a similarly named alternative to exist — an unknown name
alone is not reported, since the index does not see gems or the
standard library.

For the same reason, a namespace whose root segment names a gem in the
bundle (`Flipper` for the `flipper` gem) is left alone: a project that
reopens it (`module Flipper; module Adapters; ...`) makes it resolve in
the index, while the members the gem itself defines stay invisible and
would look like typos. Enabling `AllCops/ProjectIndexIncludesGems`
indexes those sources and restores the check.

Names that appear as symbols or inside string literals in the same
file are never reported, since they usually belong to runtime
definitions the index cannot see (`stub_const`, `const_set`,
`define_method`, and the like).

# Examples

```ruby
# bad - Services::UserCraetor is not defined, Services::UserCreator is
Services::UserCraetor.new

# good
Services::UserCreator.new

# bad - Report.generate_sumary is not defined, Report.generate_summary is
Report.generate_sumary

# good
Report.generate_summary

# good - constant references are not checked
Services::UserCraetor.new

# good - method calls are not checked
Report.generate_sumary

# good - the name is explicitly allowed
Report.generate_sumary
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NameTypo)