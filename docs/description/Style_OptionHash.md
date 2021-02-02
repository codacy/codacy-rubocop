
This cop checks for options hashes and discourages them if the
current Ruby version supports keyword arguments.

# Examples

```ruby

# bad
def fry(options = {})
  temperature = options.fetch(:temperature, 300)
  # ...
end

# good
def fry(temperature: 300)
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/OptionHash)