
Checks for mistyped shorthand assignments.

# Examples

```ruby
# bad
x =- y
x =+ y
x =* y
x =! y

# good
x -= y # or x = -y
x += y # or x = +y
x *= y # or x = *y
x != y # or x = !y
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AmbiguousAssignment)