
Checks that tests use `described_class`.

If the first argument of describe is a class, the class is exposed to
each example via described_class.

This cop can be configured using the `EnforcedStyle` and `SkipBlocks`
options.

There's a known caveat with rspec-rails's `controller` helper that
runs its block in a different context, and `described_class` is not
available to it. `SkipBlocks` option excludes detection in all
non-RSpec related blocks.

To narrow down this setting to only a specific directory, it is
possible to use an overriding configuration file local to that
directory.

# Examples

```ruby
# bad
describe MyClass do
  subject { MyClass.do_something }
end

# good
describe MyClass do
  subject { described_class.do_something }
end# bad
describe MyClass do
  subject { described_class.do_something }
end

# good
describe MyClass do
  subject { MyClass.do_something }
end# spec/controllers/.rubocop.yml
# RSpec/DescribedClass:
#   SkipBlocks: true

# acceptable
describe MyConcern do
  controller(ApplicationController) do
    include MyConcern
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/DescribedClass)