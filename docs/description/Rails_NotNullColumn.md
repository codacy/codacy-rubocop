
This cop checks for add_column call with NOT NULL constraint
in migration file.

# Examples

```ruby
# bad
add_column :users, :name, :string, null: false
add_reference :products, :category, null: false

# good
add_column :users, :name, :string, null: true
add_column :users, :name, :string, null: false, default: ''
add_reference :products, :category
add_reference :products, :category, null: false, default: 1
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/NotNullColumn)