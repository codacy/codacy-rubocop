
Enforce that gem dependency version specifications or a commit reference (branch,
ref, or tag) are either required or forbidden.

# Examples

```ruby

# bad
Gem::Specification.new do |spec|
  spec.add_dependency 'parser'
end

# bad
Gem::Specification.new do |spec|
  spec.add_development_dependency 'parser'
end

# good
Gem::Specification.new do |spec|
  spec.add_dependency 'parser', '>= 2.3.3.1', '< 3.0'
end

# good
Gem::Specification.new do |spec|
  spec.add_development_dependency 'parser', '>= 2.3.3.1', '< 3.0'
end
# bad
Gem::Specification.new do |spec|
  spec.add_dependency 'parser', '>= 2.3.3.1', '< 3.0'
end

# bad
Gem::Specification.new do |spec|
  spec.add_development_dependency 'parser', '>= 2.3.3.1', '< 3.0'
end

# good
Gem::Specification.new do |spec|
  spec.add_dependency 'parser'
end

# good
Gem::Specification.new do |spec|
  spec.add_development_dependency 'parser'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Gemspec/DependencyVersion)