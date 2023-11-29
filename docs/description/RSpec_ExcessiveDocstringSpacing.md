
Checks for excessive whitespace in example descriptions.

# Examples

```ruby
# bad
it '  has  excessive   spacing  ' do
end

# good
it 'has excessive spacing' do
end# bad
context '  when a condition   is met  ' do
end

# good
context 'when a condition is met' do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExcessiveDocstringSpacing)