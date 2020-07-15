
This cop checks for redundant `String#chars`.

# Examples

```ruby
# bad
str.chars[0..2]
str.chars.slice(0..2)

# good
str[0..2].chars

# bad
str.chars.first
str.chars.first(2)
str.chars.last
str.chars.last(2)

# good
str[0]
str[0...2].chars
str[-1]
str[-2..-1].chars

# bad
str.chars.take(2)
str.chars.drop(2)
str.chars.length
str.chars.size
str.chars.empty?

# good
str[0...2].chars
str[2..-1].chars
str.length
str.size
str.empty?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/RedundantStringChars)