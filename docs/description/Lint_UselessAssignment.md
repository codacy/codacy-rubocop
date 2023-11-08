
Checks for every useless assignment to local variable in every
scope.
The basic idea for this cop was from the warning of `ruby -cw`:

[source,console]
----
assigned but unused variable - foo
----

Currently this cop has advanced logic that detects unreferenced
reassignments and properly handles varied cases such as branch, loop,
rescue, ensure, etc.

NOTE: Given the assignment `foo = 1, bar = 2`, removing unused variables
can lead to a syntax error, so this case is not autocorrected.

# Examples

```ruby

# bad

def some_method
  some_var = 1
  do_something
end
# good

def some_method
  some_var = 1
  do_something(some_var)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessAssignment)