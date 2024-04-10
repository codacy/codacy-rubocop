
Identifies places where string identifier argument can be replaced
by symbol identifier argument.
It prevents the redundancy of the internal string-to-symbol conversion.

This cop targets methods that take identifier (e.g. method name) argument
and the following examples are parts of it.

# Examples

```ruby

# bad
send('do_something')
attr_accessor 'do_something'
instance_variable_get('@ivar')

# good
send(:do_something)
attr_accessor :do_something
instance_variable_get(:@ivar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/StringIdentifierArgument)