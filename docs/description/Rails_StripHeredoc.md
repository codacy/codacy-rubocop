
Enforces the use of squiggly heredoc over `strip_heredoc`.

# Examples

```ruby

# bad
<<EOS.strip_heredoc
  some text
EOS

# bad
<<-EOS.strip_heredoc
  some text
EOS

# good
<<~EOS
  some text
EOS
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/StripHeredoc)