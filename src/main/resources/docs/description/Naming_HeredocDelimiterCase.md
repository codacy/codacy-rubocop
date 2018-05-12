
This cop checks that your heredocs are using the configured case.
By default it is configured to enforce uppercase heredocs.

# Examples

```ruby
# bad
<<-sql
  SELECT * FROM foo
sql

# good
<<-SQL
  SELECT * FROM foo
SQL# bad
<<-SQL
  SELECT * FROM foo
SQL

# good
<<-sql
  SELECT * FROM foo
sql
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/HeredocDelimiterCase)