
This cop checks for the presence of superfluous parentheses around the
condition of if/unless/while/until.

# Examples

```ruby
# bad
x += 1 while (x < 10)
foo unless (bar || baz)

if (x > 10)
elsif (x < 3)
end

# good
x += 1 while x < 10
foo unless bar || baz

if x > 10
elsif x < 3
end# bad
if (x > 10 &&
   y > 10)
end

# good
 if x > 10 &&
    y > 10
 end# good
if (x > 10 &&
   y > 10)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ParenthesesAroundCondition)