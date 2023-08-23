
Checks whether the change method of the migration file is
reversible.

# Examples

```ruby
# bad
def change
  change_table :users do |t|
    t.remove :name
  end
end

# good
def change
  change_table :users do |t|
    t.remove :name, :string
  end
end

# good
def change
  create_table :users do |t|
    t.string :name
  end
end# drop_table

# bad
def change
  drop_table :users
end

# good
def change
  drop_table :users do |t|
    t.string :name
  end
end# change_column_default

# bad
def change
  change_column_default(:suppliers, :qualification, 'new')
end

# good
def change
  change_column_default(:posts, :state, from: nil, to: "draft")
end# remove_column

# bad
def change
  remove_column(:suppliers, :qualification)
end

# good
def change
  remove_column(:suppliers, :qualification, :string)
end# remove_foreign_key

# bad
def change
  remove_foreign_key :accounts, column: :owner_id
end

# good
def change
  remove_foreign_key :accounts, :branches
end

# good
def change
  remove_foreign_key :accounts, to_table: :branches
end# change_table

# bad
def change
  change_table :users do |t|
    t.remove :name
    t.change_default :authorized, 1
    t.change :price, :string
  end
end

# good
def change
  change_table :users do |t|
    t.string :name
  end
end# remove_columns

# bad
def change
  remove_columns :users, :name, :email
end

# good
def change
  reversible do |dir|
    dir.up do
      remove_columns :users, :name, :email
    end

    dir.down do
      add_column :users, :name, :string
      add_column :users, :email, :string
    end
  end
end

# good (Rails >= 6.1, see https://github.com/rails/rails/pull/36589)
def change
  remove_columns :users, :name, :email, type: :string
end# remove_index

# bad
def change
  remove_index :users, name: :index_users_on_email
end

# good
def change
  remove_index :users, :email
end

# good
def change
  remove_index :users, column: :email
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ReversibleMigration)