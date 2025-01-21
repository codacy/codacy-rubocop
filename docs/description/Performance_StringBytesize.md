
Checks for calls to `#bytes` counting method and suggests using `bytesize` instead.
The `bytesize` method is more efficient and directly returns the size in bytes,
avoiding the intermediate array allocation that `bytes.size` incurs.

# Examples

```ruby
# bad
string_var.bytes.count
"foobar".bytes.size

# good
string_var.bytesize
"foobar".bytesize
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/StringBytesize)