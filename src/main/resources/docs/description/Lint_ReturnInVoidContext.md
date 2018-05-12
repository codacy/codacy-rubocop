
This cop checks for the use of a return with a value in a context
where the value will be ignored. (initialize and setter methods)

# Examples

```ruby

# bad
def initialize
  foo
  return :qux if bar?
  baz
end

def foo=(bar)
  return 42
end
# good
def initialize
  foo
  return if bar?
  baz
end

def foo=(bar)
  return
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ReturnInVoidContext)