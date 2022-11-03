
Checks for using empty heredoc to reduce redundancy.

# Examples

```ruby

# bad
<<~EOS
EOS

<<-EOS
EOS

<<EOS
EOS

# good
''

# bad
do_something(<<~EOS)
EOS

do_something(<<-EOS)
EOS

do_something(<<EOS)
EOS

# good
do_something('')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EmptyHeredoc)