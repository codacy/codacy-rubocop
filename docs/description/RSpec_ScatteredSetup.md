
Checks for setup scattered across multiple hooks in an example group.

Unify `before` and `after` hooks when possible.
However, `around` hooks are allowed to be defined multiple times,
as unifying them would typically make the code harder to read.

# Examples

```ruby
# bad
describe Foo do
  before { setup1 }
  before { setup2 }
end

# good
describe Foo do
  before do
    setup1
    setup2
  end
end

# good
describe Foo do
  around { |example| before1; example.call; after1 }
  around { |example| before2; example.call; after2 }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ScatteredSetup)