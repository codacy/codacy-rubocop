
Avoid using `Dir.chdir` due to its process-wide effect.

# Examples

```ruby
# bad
Dir.chdir("/var/run")

# bad
FileUtils.chdir("/var/run")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/DirChdir)