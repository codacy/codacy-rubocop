
Checks for the use of `Kernel#eval` and `Binding#eval` with
dynamic strings as arguments. Evaluating non-literal strings
can enable code injection attacks and makes it difficult to
reason about what code will actually be executed.

Calls to `eval` with literal strings are not flagged by this cop,
as they do not pose the same injection risk.

# Examples

```ruby

# bad
eval(something)
binding.eval(something)
Kernel.eval(something)

# good - use safer alternatives
obj.public_send(method_name)
obj.send(method_name, *args)

# good - literal strings are allowed
eval("1 + 1")
binding.eval("foo")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/Eval)