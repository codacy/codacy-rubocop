
This cop checks for the presence of `method_missing` without
falling back on `super`.

# Examples

```ruby
#bad
def method_missing(name, *args)
  # ...
end

#good

def method_missing(name, *args)
  # ...
  super
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MethodMissingSuper)