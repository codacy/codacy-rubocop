
Checks for the first argument to `IO.read`, `IO.binread`, `IO.write`, `IO.binwrite`,
`IO.foreach`, and `IO.readlines`.

If argument starts with a pipe character (`'|'`) and the receiver is the `IO` class,
a subprocess is created in the same way as `Kernel#open`, and its output is returned.
`Kernel#open` may allow unintentional command injection, which is the reason these
`IO` methods are a security risk.
Consider to use `File.read` to disable the behavior of subprocess invocation.

# Examples

```ruby

# bad
IO.read(path)
IO.read('path')

# good
File.read(path)
File.read('path')
IO.read('| command') # Allow intentional command invocation.
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/IoMethods)