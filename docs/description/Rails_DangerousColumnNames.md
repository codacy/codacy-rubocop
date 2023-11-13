
Avoid dangerous column names.

Some column names are considered dangerous because they would overwrite methods already defined.

# Examples

```ruby
# bad
add_column :users, :save

# good
add_column :users, :saved
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DangerousColumnNames)