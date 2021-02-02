
Checks the indentation of here document closings.

# Examples

```ruby

# bad
class Foo
  def bar
    <<~SQL
      'Hi'
  SQL
  end
end

# good
class Foo
  def bar
    <<~SQL
      'Hi'
    SQL
  end
end

# bad

# heredoc contents is before closing heredoc.
foo arg,
    <<~EOS
  Hi
    EOS

# good
foo arg,
    <<~EOS
  Hi
EOS

# good
foo arg,
    <<~EOS
      Hi
    EOS
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/ClosingHeredocIndentation)