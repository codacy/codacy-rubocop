
Checks for unused method arguments.

# Examples

```ruby
# bad
def some_method(used, unused, _unused_but_allowed)
  puts used
end

# good
def some_method(used, _unused, _unused_but_allowed)
  puts used
end# bad
def do_something(used, unused: 42)
  used
end# good
def do_something(used, unused: 42)
  used
end# good
def do_something(unused)
end# bad
def do_something(unused)
end# good
def do_something(unused)
  raise NotImplementedError
end

def do_something_else(unused)
  fail "TODO"
end# bad
def do_something(unused)
  raise NotImplementedError
end

def do_something_else(unused)
  fail "TODO"
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnusedMethodArgument)