
This cop checks against comparing a variable with multiple items, where
`Array#include?` could be used instead to avoid code repetition.

# Examples

```ruby
# bad
a = 'a'
foo if a == 'a' || a == 'b' || a == 'c'

# good
a = 'a'
foo if ['a', 'b', 'c'].include?(a)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultipleComparison)