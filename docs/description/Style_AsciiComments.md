
Checks for non-ascii (non-English) characters
in comments. Non-ascii characters can cause issues with
portability and encoding across different environments
and editors. You could set an array of allowed non-ascii
chars in `AllowedChars` attribute (copyright notice "©"
by default).

# Examples

```ruby
# bad
# Translates from English to 日本語。

# good
# Translates from English to Japanese
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AsciiComments)