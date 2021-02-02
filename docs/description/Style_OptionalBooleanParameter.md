
This cop checks for places where keyword arguments can be used instead of
boolean arguments when defining methods. `respond_to_missing?` method is allowed by default.
These are customizable with `AllowedMethods` option.

# Examples

```ruby
# bad
def some_method(bar = false)
  puts bar
end

# bad - common hack before keyword args were introduced
def some_method(options = {})
  bar = options.fetch(:bar, false)
  puts bar
end

# good
def some_method(bar: false)
  puts bar
end# good
def some_method(bar = false)
  puts bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/OptionalBooleanParameter)