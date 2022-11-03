
Checks for the presence of superfluous parentheses around the
condition of if/unless/while/until.

`AllowSafeAssignment` option for safe assignment.
By safe assignment we mean putting parentheses around
an assignment to indicate "I know I'm using an assignment
as a condition. It's not a mistake."

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
end# good
foo unless (bar = baz)# bad
foo unless (bar = baz)# bad
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