
This cop checks for the use of Marshal class methods which have
potential security issues leading to remote code execution when
loading from an untrusted source.

# Examples

```ruby
# bad
Marshal.load("{}")
Marshal.restore("{}")

# good
Marshal.dump("{}")

# okish - deep copy hack
Marshal.load(Marshal.dump({}))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/MarshalLoad)