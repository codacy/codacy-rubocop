
This cop checks for uses of the deprecated class method usages.

# Examples

```ruby

# bad

File.exists?(some_path)
Dir.exists?(some_path)
iterator?
# good

File.exist?(some_path)
Dir.exist?(some_path)
block_given?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DeprecatedClassMethods)