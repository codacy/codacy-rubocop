
Checks for exact regexp match inside `Regexp` literals.

`=~` returns an index and `match` returns `MatchData`, so they are only
autocorrected when their value is used as a condition. The same goes for
safe navigation calls, which return `nil` for a `nil` receiver.

# Examples

```ruby

# bad
string =~ /\Astring\z/
/\Astring\z/ === string
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