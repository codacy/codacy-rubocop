
Identifies places where a case-insensitive string comparison
can better be implemented using `casecmp`.

This cop is disabled by default because `String#casecmp` only works with
ASCII characters. See https://github.com/rubocop/rubocop/issues/9753.

If you are working only with ASCII characters, then this cop can be
safely enabled.

# Examples

```ruby
# bad
str.downcase == 'abc'
str.upcase.eql? 'ABC'
'abc' == str.downcase
'ABC'.eql? str.upcase
str.downcase == str.downcase

# good
str.casecmp('ABC').zero?
'abc'.casecmp(str).zero?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/Casecmp)