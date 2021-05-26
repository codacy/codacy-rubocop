
This cop checks for uses of the deprecated class method usages.

# Examples

```ruby

# bad

File.exists?(some_path)
Dir.exists?(some_path)
iterator?
Socket.gethostbyname(host)
Socket.gethostbyaddr(host)
# good

File.exist?(some_path)
Dir.exist?(some_path)
block_given?
Addrinfo.getaddrinfo(nodename, service)
Addrinfo.tcp(host, port).getnameinfo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DeprecatedClassMethods)