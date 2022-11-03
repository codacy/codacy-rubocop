
Identifies passing any argument to `#to_s`.

# Examples

```ruby

# bad
obj.to_s(:delimited)

# good
obj.to_formatted_s(:delimited)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ToSWithArgument)