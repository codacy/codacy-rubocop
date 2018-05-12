
Checks if uses of quotes match the configured preference.

# Examples

```ruby
# bad
"No special symbols"
"No string interpolation"
"Just text"

# good
'No special symbols'
'No string interpolation'
'Just text'
"Wait! What's #{this}!"# bad
'Just some text'
'No special chars or interpolation'

# good
"Just some text"
"No special chars or interpolation"
"Every string in #{project} uses double_quotes"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StringLiterals)