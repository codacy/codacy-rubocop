
Checks for operators, variables, literals, lambda, proc and nonmutating
methods used in void context.

`each` blocks are allowed to prevent false positives.
For example, the expression inside the `each` block below.
It's not void, especially when the receiver is an `Enumerator`:

[source,ruby]
----
enumerator = [1, 2, 3].filter
enumerator.each { |item| item >= 2 } #=> [2, 3]
----

# Examples

```ruby
# bad
def some_method
  some_num * 10
  do_something
end

def some_method(some_var)
  some_var
  do_something
end# bad
def some_method(some_array)
  some_array.sort
  do_something(some_array)
end

# good
def some_method
  do_something
  some_num * 10
end

def some_method(some_var)
  do_something
  some_var
end

def some_method(some_array)
  some_array.sort!
  do_something(some_array)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Void)