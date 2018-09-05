
This cop checks for nested percent literals.

# Examples

```ruby

# bad

# The percent literal for nested_attributes is parsed as four tokens,
# yielding the array [:name, :content, :"%i[incorrectly", :"nested]"].
attributes = {
  valid_attributes: %i[name content],
  nested_attributes: %i[name content %i[incorrectly nested]]
}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NestedPercentLiteral)