
Dependencies in the gemspec should be alphabetically sorted.

# Examples

```ruby
# bad
spec.add_dependency 'rubocop'
spec.add_dependency 'rspec'

# good
spec.add_dependency 'rspec'
spec.add_dependency 'rubocop'

# good
spec.add_dependency 'rubocop'

spec.add_dependency 'rspec'

# bad
spec.add_development_dependency 'rubocop'
spec.add_development_dependency 'rspec'

# good
spec.add_development_dependency 'rspec'
spec.add_development_dependency 'rubocop'

# good
spec.add_development_dependency 'rubocop'

spec.add_development_dependency 'rspec'

# bad
spec.add_runtime_dependency 'rubocop'
spec.add_runtime_dependency 'rspec'

# good
spec.add_runtime_dependency 'rspec'
spec.add_runtime_dependency 'rubocop'

# good
spec.add_runtime_dependency 'rubocop'

spec.add_runtime_dependency 'rspec'

# good only if TreatCommentsAsGroupSeparators is true
# For code quality
spec.add_dependency 'rubocop'
# For tests
spec.add_dependency 'rspec'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Gemspec/OrderedDependencies)