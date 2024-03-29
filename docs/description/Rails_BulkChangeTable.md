
Checks whether alter queries are combinable.
If combinable queries are detected, it suggests to you
to use `change_table` with `bulk: true` instead.
This option causes the migration to generate a single
ALTER TABLE statement combining multiple column alterations.

The `bulk` option is only supported on the MySQL and
the PostgreSQL (5.2 later) adapter; thus it will
automatically detect an adapter from `development` environment
in `config/database.yml` or the environment variable `DATABASE_URL`
when the `Database` option is not set.
If the adapter is not `mysql2`, `trilogy`, `postgresql`, or `postgis`,
this Cop ignores offenses.

# Examples

```ruby
# bad
def change
  add_column :users, :name, :string, null: false
  add_column :users, :nickname, :string

  # ALTER TABLE `users` ADD `name` varchar(255) NOT NULL
  # ALTER TABLE `users` ADD `nickname` varchar(255)
end

# good
def change
  change_table :users, bulk: true do |t|
    t.string :name, null: false
    t.string :nickname
  end

  # ALTER TABLE `users` ADD `name` varchar(255) NOT NULL,
  #                     ADD `nickname` varchar(255)
end# bad
def change
  change_table :users do |t|
    t.string :name, null: false
    t.string :nickname
  end
end

# good
def change
  change_table :users, bulk: true do |t|
    t.string :name, null: false
    t.string :nickname
  end
end

# good
# When you don't want to combine alter queries.
def change
  change_table :users, bulk: false do |t|
    t.string :name, null: false
    t.string :nickname
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/BulkChangeTable)