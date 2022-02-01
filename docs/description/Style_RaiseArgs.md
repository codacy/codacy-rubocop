
This cop checks the args passed to `fail` and `raise`. For exploded
style (default), it recommends passing the exception class and message
to `raise`, rather than construct an instance of the error. It will
still allow passing just a message, or the construction of an error
with more than one argument.

The exploded style works identically, but with the addition that it
will also suggest constructing error objects when the exception is
passed multiple arguments.

The exploded style has an `AllowedCompactTypes` configuration
option that takes an Array of exception name Strings.

# Examples

```ruby
# bad
raise StandardError.new('message')

# good
raise StandardError, 'message'
fail 'message'
raise MyCustomError
raise MyCustomError.new(arg1, arg2, arg3)
raise MyKwArgError.new(key1: val1, key2: val2)

# With `AllowedCompactTypes` set to ['MyWrappedError']
raise MyWrappedError.new(obj)
raise MyWrappedError.new(obj), 'message'# bad
raise StandardError, 'message'
raise RuntimeError, arg1, arg2, arg3

# good
raise StandardError.new('message')
raise MyCustomError
raise MyCustomError.new(arg1, arg2, arg3)
fail 'message'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RaiseArgs)