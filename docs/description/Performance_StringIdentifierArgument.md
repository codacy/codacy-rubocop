
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

# good - these methods don't support namespaced symbols
const_get("#{module_path}::Base")
const_source_location("#{module_path}::Base")
const_defined?("#{module_path}::Base")

# good - using a symbol when string interpolation is involved causes a performance regression.
respond_to?("string_#{interpolation}")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/StringIdentifierArgument)