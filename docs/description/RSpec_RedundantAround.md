
Remove redundant `around` hook.

# Examples

```ruby
# bad
around do |example|
  example.run
end

# good
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RedundantAround)