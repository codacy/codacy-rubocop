
Check that the first argument to the top-level describe is a constant.

It can be configured to ignore strings when certain metadata is passed.

Ignores Rails and Aruba `type` metadata by default.

# Examples

```ruby
# .rubocop.yml
# RSpec/DescribeClass:
#   IgnoredMetadata:
#     type:
#       - request
#       - controller# bad
describe 'Do something' do
end

# good
describe TestedClass do
  subject { described_class }
end

describe 'TestedClass::VERSION' do
  subject { Object.const_get(self.class.description) }
end

describe "A feature example", type: :feature do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/DescribeClass)