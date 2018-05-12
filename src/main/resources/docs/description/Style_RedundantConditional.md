
This cop checks for redundant returning of true/false in conditionals.

# Examples

```ruby
# bad
x == y ? true : false

# bad
if x == y
  true
else
  false
end

# good
x == y

# bad
x == y ? false : true

# good
x != y
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantConditional)