
This cop detects method definition in a task or namespace,
because it is defined to the top level.
It is confusing because the scope looks in the task or namespace,
but actually it is defined to the top level.

# Examples

```ruby
# bad
task :foo do
  def helper_method
    do_something
  end
end

# bad
namespace :foo do
  def helper_method
    do_something
  end
end

# good - It is also defined to the top level,
#        but it looks expected behavior.
def helper_method
end
task :foo do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rake/MethodDefinitionInTask)