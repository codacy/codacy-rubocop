
Identifies uses of `Range#include?` and `Range#member?`, which iterates over each
item in a `Range` to see if a specified item is there. In contrast,
`Range#cover?` simply compares the target item with the beginning and
end points of the `Range`. In a great majority of cases, this is what
is wanted.

# Examples

```ruby
# bad
('a'..'z').include?('b') # => true
('a'..'z').member?('b')  # => true

# good
('a'..'z').cover?('b') # => true
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RangeInclude)