
This cop checks for the presence of `method_missing` without also
defining `respond_to_missing?`.

# Examples

```ruby
#bad
def method_missing(name, *args)
  # ...
end

#good
def respond_to_missing?(name, include_private)
  # ...
end

def method_missing(name, *args)
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MissingRespondToMissing)