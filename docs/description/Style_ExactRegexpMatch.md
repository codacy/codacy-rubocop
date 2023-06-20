
Checks for exact regexp match inside Regexp literals.

# Examples

```ruby

# bad
string =~ /\Astring\z/
string === /\Astring\z/
string.match(/\Astring\z/)
string.match?(/\Astring\z/)

# good
string == 'string'

# bad
string !~ /\Astring\z/

# good
string != 'string'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ExactRegexpMatch)