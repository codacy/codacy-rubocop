
This cop checks for non-ascii (non-English) characters
in comments. You could set an array of allowed non-ascii chars in
AllowedChars attribute (empty by default).

# Examples

```ruby
# bad
# Translates from English to 日本語。

# good
# Translates from English to Japanese
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AsciiComments)