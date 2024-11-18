
Checks for predicate method definitions that return `nil`.
A predicate method should only return a boolean value.

# Examples

```ruby
# bad
def foo?
  return if condition

  do_something?
end

# bad
def foo?
  return nil if condition

  do_something?
end

# good
def foo?
  return false if condition

  do_something?
end

# bad
def foo?
  if condition
    nil
  else
    true
  end
end

# good
def foo?
  if condition
    false
  else
    true
  end
end# good
def foo?
  return if condition

  do_something?
end# good
def foo?
  return if condition

  do_something?
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ReturnNilInPredicateMethodDefinition)