
If tasks are defined with the same name, Rake executes the both tasks
in definition order.
It is misleading sometimes. You should squash them into one definition.
This cop detects it.

# Examples

```ruby
# bad
task :foo do
  p 'foo 1'
end
task :foo do
  p 'foo 2'
end

# good
task :foo do
  p 'foo 1'
  p 'foo 2'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rake/DuplicateTask)