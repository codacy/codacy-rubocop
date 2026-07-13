
Checks that `RUBY_VERSION` and `Ruby::VERSION` constants are not used in gemspec.
Using `RUBY_VERSION` and `Ruby::VERSION` is dangerous because the value of the
constant is determined by `rake release`.
It's possible to have a dependency based on the Ruby version used
to execute `rake release` and not the user's Ruby version.

# Examples

```ruby

# bad
Gem::Specification.new do |spec|
  if RUBY_VERSION >= '3.0'
    spec.add_dependency 'gem_a'
  else
    spec.add_dependency 'gem_b'
  end
end

# good
Gem::Specification.new do |spec|
  spec.add_dependency 'gem_a'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Gemspec/RubyVersionGlobalsUsage)