
Identifies places where `array.reverse.find` can be replaced by `array.rfind`.

# Examples

```ruby
# bad
array.reverse.find { |item| item.even? }
array.reverse.detect { |item| item.even? }
array.reverse_each.find { |item| item.even? }
array.reverse_each.detect { |item| item.even? }

# good
array.rfind { |item| item.even? }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ReverseFind)