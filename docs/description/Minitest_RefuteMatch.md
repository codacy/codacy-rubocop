
Enforces the test to use `refute_match`
instead of using `refute(matcher.match(string))`.

# Examples

```ruby
# bad
refute(matcher.match(string))
refute(matcher.match?(string))
refute(matcher =~ string)
refute(matcher.match(string), 'message')

# good
refute_match(matcher, string)
refute_match(matcher, string, 'message')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/RefuteMatch)