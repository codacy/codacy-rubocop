
This cop checks for shadowed arguments.

# Examples

```ruby

# bad

do_something do |foo|
  foo = 42
  puts foo
end

def do_something(foo)
  foo = 42
  puts foo
end
# good

do_something do |foo|
  foo = foo + 42
  puts foo
end

def do_something(foo)
  foo = foo + 42
  puts foo
end

def do_something(foo)
  puts foo
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ShadowedArgument)