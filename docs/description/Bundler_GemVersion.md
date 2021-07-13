
Enforce that Gem version specifications are either required
or forbidden.

# Examples

```ruby
# bad
gem 'rubocop'

# good
gem 'rubocop', '~> 1.12'

# good
gem 'rubocop', '>= 1.10.0'

# good
gem 'rubocop', '>= 1.5.0', '< 1.10.0'# good
gem 'rubocop'

# bad
gem 'rubocop', '~> 1.12'

# bad
gem 'rubocop', '>= 1.10.0'

# bad
gem 'rubocop', '>= 1.5.0', '< 1.10.0'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Bundler/GemVersion)