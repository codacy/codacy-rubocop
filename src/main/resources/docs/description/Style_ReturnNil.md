
This cop enforces consistency between 'return nil' and 'return'.

Supported styles are: return, return_nil.

# Examples

```ruby
# bad
def foo(arg)
  return nil if arg
end

# good
def foo(arg)
  return if arg
end# bad
def foo(arg)
  return if arg
end

# good
def foo(arg)
  return nil if arg
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ReturnNil)