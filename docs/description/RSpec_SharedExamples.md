
Checks for consistent style for shared example names.

Enforces either `string` or `symbol` for shared example names.

This cop can be configured using the `EnforcedStyle` option

# Examples

```ruby
# bad
it_behaves_like :foo_bar_baz
it_should_behave_like :foo_bar_baz
shared_examples :foo_bar_baz
shared_examples_for :foo_bar_baz
include_examples :foo_bar_baz

# good
it_behaves_like 'foo bar baz'
it_should_behave_like 'foo bar baz'
shared_examples 'foo bar baz'
shared_examples_for 'foo bar baz'
include_examples 'foo bar baz'# bad
it_behaves_like 'foo bar baz'
it_should_behave_like 'foo bar baz'
shared_examples 'foo bar baz'
shared_examples_for 'foo bar baz'
include_examples 'foo bar baz'

# good
it_behaves_like :foo_bar_baz
it_should_behave_like :foo_bar_baz
shared_examples :foo_bar_baz
shared_examples_for :foo_bar_baz
include_examples :foo_bar_baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SharedExamples)