
This cop checks that your heredocs are using meaningful delimiters.
By default it disallows `END` and `EO*`, and can be configured through
blacklisting additional delimiters.

# Examples

```ruby

# good
<<-SQL
  SELECT * FROM foo
SQL

# bad
<<-END
  SELECT * FROM foo
END

# bad
<<-EOS
  SELECT * FROM foo
EOS
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/HeredocDelimiterNaming)