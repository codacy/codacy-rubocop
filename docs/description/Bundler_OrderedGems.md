
Gems should be alphabetically sorted within groups.

# Examples

```ruby
# bad
gem 'rubocop'
gem 'rspec'

# good
gem 'rspec'
gem 'rubocop'

# good
gem 'rubocop'

gem 'rspec'# good
# For code quality
gem 'rubocop'
# For tests
gem 'rspec'# bad
# For code quality
gem 'rubocop'
# For tests
gem 'rspec'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Bundler/OrderedGems)