
Checks for `if` expressions that do not have an `else` branch.

Supported styles are: if, case, both.

# Examples

```ruby
# warn when an `if` expression is missing an `else` branch.

# bad
if condition
  statement
end

# good
if condition
  statement
else
  # the content of `else` branch will be determined by Style/EmptyElse
end

# good
case var
when condition
  statement
end

# good
case var
when condition
  statement
else
  # the content of `else` branch will be determined by Style/EmptyElse
end# warn when a `case` expression is missing an `else` branch.

# bad
case var
when condition
  statement
end

# good
case var
when condition
  statement
else
  # the content of `else` branch will be determined by Style/EmptyElse
end

# good
if condition
  statement
end

# good
if condition
  statement
else
  # the content of `else` branch will be determined by Style/EmptyElse
end# warn when an `if` or `case` expression is missing an `else` branch.

# bad
if condition
  statement
end

# bad
case var
when condition
  statement
end

# good
if condition
  statement
else
  # the content of `else` branch will be determined by Style/EmptyElse
end

# good
case var
when condition
  statement
else
  # the content of `else` branch will be determined by Style/EmptyElse
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MissingElse)