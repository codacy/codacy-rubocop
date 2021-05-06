
This cop checks that `date =` is not used in gemspec file.
It is set automatically when the gem is packaged.

# Examples

```ruby

# bad
Gem::Specification.new do |spec|
  s.name = 'your_cool_gem_name'
  spec.date = Time.now.strftime('%Y-%m-%d')
end

# good
Gem::Specification.new do |spec|
  s.name = 'your_cool_gem_name'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Gemspec/DateAssignment)