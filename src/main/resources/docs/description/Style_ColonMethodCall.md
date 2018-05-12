
This cop checks for methods invoked via the :: operator instead
of the . operator (like FileUtils::rmdir instead of FileUtils.rmdir).

# Examples

```ruby
# bad
Timeout::timeout(500) { do_something }
FileUtils::rmdir(dir)
Marshal::dump(obj)

# good
Timeout.timeout(500) { do_something }
FileUtils.rmdir(dir)
Marshal.dump(obj)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ColonMethodCall)