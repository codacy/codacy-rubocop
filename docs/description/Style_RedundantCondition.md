
Checks for unnecessary conditional expressions.

# Examples

```ruby
# bad
a = b ? b : c

# good
a = b || c# bad
if b
  b
else
  c
end

# good
b || c

# good
if b
  b
elsif cond
  c
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantCondition)