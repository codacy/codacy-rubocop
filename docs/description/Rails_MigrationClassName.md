
Makes sure that each migration file defines a migration class
whose name matches the file name.
(e.g. `20220224111111_create_users.rb` should define `CreateUsers` class.)

# Examples

```ruby
# db/migrate/20220224111111_create_users.rb

# bad
class SellBooks < ActiveRecord::Migration[7.0]
end

# good
class CreateUsers < ActiveRecord::Migration[7.0]
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/MigrationClassName)