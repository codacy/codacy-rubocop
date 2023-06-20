
Enforces that boolean columns are created with default values (`false` or `true`) and
`NOT NULL` constraint.

# Examples

```ruby
# bad
add_column :users, :active, :boolean
t.column :active, :boolean
t.boolean :active

# good
add_column :users, :active, :boolean, default: true, null: false
t.column :active, :boolean, default: true, null: false
t.boolean :active, default: true, null: false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ThreeStateBooleanColumn)