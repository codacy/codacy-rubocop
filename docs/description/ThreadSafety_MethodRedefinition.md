
Avoid the thread-unsafe combination of remove_method followed by defining a method with the same name.
This can lead to a race condition, as these two actions are not atomic.
As a safer alternative, consider aliasing the method to itself instead.

# Examples

```ruby
# bad
remove_method :foo
def foo; end

# good
alias_method :foo, :foo
def foo; end

# good
alias foo foo
def foo; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/MethodRedefinition)