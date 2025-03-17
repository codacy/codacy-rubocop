
Avoid using `Dir.chdir` due to its process-wide effect.
If `AllowCallWithBlock` (disabled by default) option is enabled,
calling `Dir.chdir` with block will be allowed.

# Examples

```ruby
# bad
Dir.chdir("/var/run")

# bad
FileUtils.chdir("/var/run")# good
Dir.chdir("/var/run") do
  puts Dir.pwd
end# bad
Dir.chdir("/var/run") do
  puts Dir.pwd
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/DirChdir)