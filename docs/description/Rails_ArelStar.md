
Prevents usage of `"*"` on an Arel::Table column reference.

Using `arel_table["\*"]` causes the outputted string to be a literal
quoted asterisk (e.g. `my_model`.`*`). This causes the
database to look for a column named `\*` (or `"*"`) as opposed
to expanding the column list as one would likely expect.

# Examples

```ruby
# bad
MyTable.arel_table["*"]

# good
MyTable.arel_table[Arel.star]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ArelStar)