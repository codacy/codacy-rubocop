
This cop checks for uses of the deprecated class method usages.

# Examples

```ruby

# bad

File.exists?(some_path)
Dir.exists?(some_path)
iterator?
ENV.freeze # Calling `Env.freeze` raises `TypeError` since Ruby 2.7.
Socket.gethostbyname(host)
Socket.gethostbyaddr(host)
# good

File.exist?(some_path)
Dir.exist?(some_path)
block_given?
ENV # `ENV.freeze` cannot prohibit changes to environment variables.
Addrinfo.getaddrinfo(nodename, service)
Addrinfo.tcp(host, port).getnameinfo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DeprecatedClassMethods)