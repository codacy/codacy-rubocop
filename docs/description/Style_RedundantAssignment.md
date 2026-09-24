
Checks for redundant assignment before returning.

When there are comments between the assignment and reference,
the cop will report an offense but it will not autocorrect.

# Examples

```ruby
# bad
def test
  x = foo
  x
end

# bad
def test
  if x
    z = foo
    z
  elsif y
    z = bar
    z
  end
end

# good
def test
  foo
end

# good
def test
  if x
    foo
  elsif y
    bar
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantAssignment)