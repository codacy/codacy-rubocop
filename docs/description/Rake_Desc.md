
Rake task definition should have a description with `desc` method.
It is useful as a documentation of task. And Rake does not display
task that does not have `desc` by `rake -T`.

Note: This cop does not require description for the default task,
      because the default task is executed with `rake` without command.

# Examples

```ruby
# bad
task :do_something

# bad
task :do_something do
end

# good
desc 'Do something'
task :do_something

# good
desc 'Do something'
task :do_something do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rake/Desc)