
Checks for loops which iterate a constant number of times,
using a `Range` literal and `#each`. This can be done more readably using
`Integer#times`.

This check only applies if the block takes no parameters.

# Examples

```ruby
# bad
(1..5).each { }

# good
5.times { }

# bad
(0...10).each {}

# good
10.times {}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EachForSimpleLoop)