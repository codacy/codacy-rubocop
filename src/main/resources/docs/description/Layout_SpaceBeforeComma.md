
Checks for comma (,) preceded by space.

# Examples

```ruby
# bad
[1 , 2 , 3]
a(1 , 2)
each { |a , b| }

# good
[1, 2, 3]
a(1, 2)
each { |a, b| }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceBeforeComma)