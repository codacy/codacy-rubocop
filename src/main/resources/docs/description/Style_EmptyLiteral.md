
This cop checks for the use of a method, the result of which
would be a literal, like an empty array, hash or string.

# Examples

```ruby
# bad
a = Array.new
h = Hash.new
s = String.new

# good
a = []
h = {}
s = ''
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyLiteral)