
Checks for uses of `String#split` with empty string or regexp literal argument.

# Examples

```ruby
# bad
string.split(//)
string.split('')

# good
string.chars
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StringChars)