
Suggests you remove a column that does not exist in the schema from `ignored_columns`.
`ignored_columns` is necessary to drop a column from RDBMS, but you don't need it after the migration
to drop the column. You avoid forgetting to remove `ignored_columns` by this cop.

IMPORTANT: This cop can't be used to effectively check for unused columns because the development
and production schema can be out of sync until the migration has been run on production. As such,
this cop can cause `ignored_columns` to be removed even though the production schema still contains
the column, which can lead to downtime when the migration is actually executed. Only enable this cop
if you know your migrations will be run before any of your Rails applications boot with the modified code.

# Examples

```ruby
# bad
class User < ApplicationRecord
  self.ignored_columns = [:already_removed_column]
end

# good
class User < ApplicationRecord
  self.ignored_columns = [:still_existing_column]
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UnusedIgnoredColumns)