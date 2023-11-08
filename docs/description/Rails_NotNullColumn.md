
Checks for add_column call with NOT NULL constraint in migration file.

`TEXT` can have default values in PostgreSQL, but not in MySQL.
It will automatically detect an adapter from `development` environment
in `config/database.yml` or the environment variable `DATABASE_URL`
when the `Database` option is not set. If the database is MySQL,
this cop ignores offenses for the `TEXT`.

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