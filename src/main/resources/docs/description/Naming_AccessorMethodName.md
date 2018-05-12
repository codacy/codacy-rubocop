
This cop makes sure that accessor methods are named properly.

# Examples

```ruby
# bad
def set_attribute(value)
end

# good
def attribute=(value)
end

# bad
def get_attribute
end

# good
def attribute
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/AccessorMethodName)