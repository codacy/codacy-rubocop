You should use Hash#key? instead of Hash#has_key? and Hash#value? instead of Hash#has_value? since the longer forms
are considered deprecated

**Examples:**

```
# bad
hash.has_key?(:test)
hash.has_value?(value)

# good
hash.key?(:test)
hash.value?(value)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DeprecatedHashMethods)