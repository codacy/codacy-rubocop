
Identifies places where a case-insensitive string comparison
can better be implemented using `casecmp`.

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