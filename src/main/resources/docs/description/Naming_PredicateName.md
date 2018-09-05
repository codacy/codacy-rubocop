
This cop makes sure that predicates are named properly.

# Examples

```ruby
# bad
def is_even?(value)
end

# good
def even?(value)
end

# bad
def has_value?
end

# good
def value?
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/PredicateName)