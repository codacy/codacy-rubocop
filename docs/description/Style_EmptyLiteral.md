
Checks for the use of a method, the result of which
would be a literal, like an empty array, hash, or string.

# Examples

```ruby
# bad
a = Array.new
a = Array[]
h = Hash.new
h = Hash[]
s = String.new

# good
a = []
h = {}
s = ''
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyLiteral)