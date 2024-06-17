
Checks for add_column calls with a NOT NULL constraint without a default
value.

This cop only applies when adding a column to an existing table, since
existing records will not have a value for the new column. New tables
can freely use NOT NULL columns without defaults, since there are no
records that could violate the constraint.

If you need to add a NOT NULL column to an existing table, you must add
it as nullable first, back-fill the data, and then use
`change_column_null`. Alternatively, you could add the column with a
default first to have the database automatically backfill existing rows,
and then use `change_column_default` to remove the default.

`TEXT` cannot have a default value in MySQL.
The cop will automatically detect an adapter from `development`
environment in `config/database.yml` or the environment variable
`DATABASE_URL` when the `Database` option is not set. If the database
is MySQL, this cop ignores offenses for `TEXT` columns.

# Examples

```ruby
# bad
add_column :users, :name, :string, null: false
add_reference :products, :category, null: false
change_table :users do |t|
  t.string :name, null: false
end

# good
add_column :users, :name, :string, null: true
add_column :users, :name, :string, null: false, default: ''
change_table :users do |t|
  t.string :name, null: false, default: ''
end
add_reference :products, :category
change_column_null :products, :category_id, false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/NotNullColumn)