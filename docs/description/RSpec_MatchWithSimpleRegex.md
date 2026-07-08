
Enforces the use of `include` matcher instead of `match` when the
matcher is a simple string literal without regex-specific features.

When `match` is used with a regex that contains only literal characters
(no anchors, character classes, quantifiers, alternations, or
metacharacters), it's clearer to use the `include` matcher instead.

# Examples

```ruby
# bad
expect('foobar').to match(/foo/)
expect(response.body).to match(/http:\/\/example\.com/)

# good
expect('foobar').to include('foo')
expect(response.body).to include('http://example.com')

# good - regex features needed
expect('foobar').to match(/^foo/)     # anchor
expect('foobar').to match(/foo\d+/)   # quantifier
expect('foobar').to match(/foo[ob]/)  # character class
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MatchWithSimpleRegex)