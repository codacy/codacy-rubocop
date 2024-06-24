
Checks for redundant `within find(...)` calls.

# Examples

```ruby
# bad
within find('foo.bar') do
  # ...
end

# good
within 'foo.bar' do
  # ...
end

# bad
within find_by_id('foo') do
  # ...
end

# good
within '#foo' do
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RedundantWithinFind)