
Always declare attribute values as blocks.

# Examples

```ruby
# bad
kind [:active, :rejected].sample

# good
kind { [:active, :rejected].sample }

# bad
closed_at 1.day.from_now

# good
closed_at { 1.day.from_now }

# bad
count 1

# good
count { 1 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/FactoryBot/AttributeDefinedStatically)