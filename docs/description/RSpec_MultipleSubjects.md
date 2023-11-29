
Checks if an example group defines `subject` multiple times.

This cop does not support autocorrection in some cases.
The autocorrect behavior for this cop depends on the type of
duplication:

  - If multiple named subjects are defined then this probably indicates
    that the overwritten subjects (all subjects except the last
    definition) are effectively being used to define helpers. In this
    case they are replaced with `let`.

  - If multiple unnamed subjects are defined though then this can *only*
    be dead code and we remove the overwritten subject definitions.

  - If subjects are defined with `subject!` then we don't autocorrect.
    This is enough of an edge case that people can just move this to
    a `before` hook on their own

# Examples

```ruby
# bad
describe Foo do
  subject(:user) { User.new }
  subject(:post) { Post.new }
end

# good
describe Foo do
  let(:user) { User.new }
  subject(:post) { Post.new }
end

# bad (does not support autocorrection)
describe Foo do
  subject!(:user) { User.new }
  subject!(:post) { Post.new }
end

# good
describe Foo do
  before do
    User.new
    Post.new
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MultipleSubjects)