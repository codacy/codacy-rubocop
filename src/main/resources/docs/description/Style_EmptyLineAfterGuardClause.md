
This cop enforces empty line after guard clause

# Examples

```ruby

# bad
def foo
  return if need_return?
  bar
end

# good
def foo
  return if need_return?

  bar
end

# good
def foo
  return if something?
  return if something_different?

  bar
end

# also good
def foo
  if something?
    do_something
    return if need_return?
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyLineAfterGuardClause)