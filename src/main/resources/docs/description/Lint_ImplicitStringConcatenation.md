
This cop checks for implicit string concatenation of string literals
which are on the same line.

# Examples

```ruby

# bad

array = ['Item 1' 'Item 2']
# good

array = ['Item 1Item 2']
array = ['Item 1' + 'Item 2']
array = [
  'Item 1' \
  'Item 2'
]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ImplicitStringConcatenation)