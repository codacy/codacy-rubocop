
This cop checks whether the migration implements
either a `change` method or both an `up` and a `down`
method.

# Examples

```ruby
# bad
class SomeMigration < ActiveRecord::Migration[6.0]
  def up
    # up migration
  end

  # <----- missing down method
end

class SomeMigration < ActiveRecord::Migration[6.0]
  # <----- missing up method

  def down
    # down migration
  end
end

# good
class SomeMigration < ActiveRecord::Migration[6.0]
  def change
    # reversible migration
  end
end

# good
class SomeMigration < ActiveRecord::Migration[6.0]
  def up
    # up migration
  end

  def down
    # down migration
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ReversibleMigrationMethodDefinition)