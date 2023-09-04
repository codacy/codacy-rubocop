
Checks if `return` or `return nil` is used in predicate method definitions.

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