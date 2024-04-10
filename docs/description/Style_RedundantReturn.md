
Checks for redundant `return` expressions.

# Examples

```ruby
# These bad cases should be extended to handle methods whose body is
# if/else or a case expression with a default branch.

# bad
def test
  return something
end

# bad
def test
  one
  two
  three
  return something
end

# good
def test
  return something if something_else
end

# good
def test
  if x
  elsif y
  else
  end
end# bad
def test
  return x, y
end# good
def test
  return x, y
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantReturn)