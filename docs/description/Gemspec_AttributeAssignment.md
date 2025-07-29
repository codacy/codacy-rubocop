
Use consistent style for Gemspec attributes assignment.

# Examples

```ruby

# bad
# This example uses two styles for assignment of metadata attribute.
Gem::Specification.new do |spec|
  spec.metadata = { 'key' => 'value' }
  spec.metadata['another-key'] = 'another-value'
end

# good
Gem::Specification.new do |spec|
  spec.metadata['key'] = 'value'
  spec.metadata['another-key'] = 'another-value'
end

# good
Gem::Specification.new do |spec|
  spec.metadata = { 'key' => 'value', 'another-key' => 'another-value' }
end

# bad
# This example uses two styles for assignment of authors attribute.
Gem::Specification.new do |spec|
  spec.authors = %w[author-0 author-1]
  spec.authors[2] = 'author-2'
end

# good
Gem::Specification.new do |spec|
  spec.authors = %w[author-0 author-1 author-2]
end

# good
Gem::Specification.new do |spec|
  spec.authors[0] = 'author-0'
  spec.authors[1] = 'author-1'
  spec.authors[2] = 'author-2'
end

# good
# This example uses consistent assignment per attribute,
# even though two different styles are used overall.
Gem::Specification.new do |spec|
  spec.metadata = { 'key' => 'value' }
  spec.authors[0] = 'author-0'
  spec.authors[1] = 'author-1'
  spec.authors[2] = 'author-2'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Gemspec/AttributeAssignment)