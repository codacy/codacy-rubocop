
Checks the migration for which timestamps are not included when creating a new table.
In many cases, timestamps are useful information and should be added.

NOTE: Allow `timestamps` not written when `id: false` because this emphasizes respecting
user's editing intentions.

# Examples

```ruby
# bad
create_table :users

# bad
create_table :users do |t|
  t.string :name
  t.string :email
end

# good
create_table :users do |t|
  t.string :name
  t.string :email

  t.timestamps
end

# good
create_table :users do |t|
  t.string :name
  t.string :email

  t.datetime :created_at, default: -> { 'CURRENT_TIMESTAMP' }
end

# good
create_table :users do |t|
  t.string :name
  t.string :email

  t.datetime :updated_at, default: -> { 'CURRENT_TIMESTAMP' }
end

# good
create_table :users, articles, id: false do |t|
  t.integer :user_id
  t.integer :article_id
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/CreateTableWithTimestamps)