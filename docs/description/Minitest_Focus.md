
Enforces tests are not focused.

# Examples

```ruby
# bad
focus test 'foo' do
end

# bad
focus
test 'foo' do
end

# good
test 'foo' do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/Focus)