
This cop checks for operators, variables, literals, and nonmutating
methods used in void context.

# Examples

```ruby

# bad

def some_method
  some_num * 10
  do_something
end
# bad

def some_method(some_var)
  some_var
  do_something
end
# bad, when CheckForMethodsWithNoSideEffects is set true

def some_method(some_array)
  some_array.sort
  do_something(some_array)
end
# good

def some_method
  do_something
  some_num * 10
end
# good

def some_method(some_var)
  do_something
  some_var
end
# good, when CheckForMethodsWithNoSideEffects is set true

def some_method(some_array)
  some_array.sort!
  do_something(some_array)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Void)