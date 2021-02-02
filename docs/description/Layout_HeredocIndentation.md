
This cop checks the indentation of the here document bodies. The bodies
are indented one step.

Note: When ``Layout/LineLength``'s `AllowHeredoc` is false (not default),
      this cop does not add any offenses for long here documents to
      avoid `Layout/LineLength`'s offenses.

# Examples

```ruby
# bad
<<-RUBY
something
RUBY

# good
<<~RUBY
  something
RUBY
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/HeredocIndentation)