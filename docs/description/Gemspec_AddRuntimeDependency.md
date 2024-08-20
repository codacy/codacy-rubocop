
Prefer `add_dependency` over `add_runtime_dependency` as the latter is
considered soft-deprecated.

# Examples

```ruby

# bad
Gem::Specification.new do |spec|
  spec.add_runtime_dependency('rubocop')
end

# good
Gem::Specification.new do |spec|
  spec.add_dependency('rubocop')
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Gemspec/AddRuntimeDependency)