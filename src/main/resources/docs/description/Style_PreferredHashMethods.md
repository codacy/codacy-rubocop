
This cop (by default) checks for uses of methods Hash#has_key? and
Hash#has_value? where it enforces Hash#key? and Hash#value?
It is configurable to enforce the inverse, using `verbose` method
names also.

# Examples

```ruby
# bad
Hash#has_key?
Hash#has_value?

# good
Hash#key?
Hash#value?# bad
Hash#key?
Hash#value?

# good
Hash#has_key?
Hash#has_value?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/PreferredHashMethods)