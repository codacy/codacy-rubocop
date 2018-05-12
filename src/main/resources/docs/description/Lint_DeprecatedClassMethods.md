
This cop checks for uses of the deprecated class method usages.

# Examples

```ruby

# bad

File.exists?(some_path)
# good

File.exist?(some_path)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DeprecatedClassMethods)