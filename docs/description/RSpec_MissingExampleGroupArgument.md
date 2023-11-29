
Checks that the first argument to an example group is not empty.

# Examples

```ruby
# bad
describe do
end

RSpec.describe do
end

# good
describe TestedClass do
end

describe "A feature example" do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MissingExampleGroupArgument)