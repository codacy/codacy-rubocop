
Detect redundant `all` used as a receiver for Active Record query methods.

NOTE: For the methods `delete_all` and `destroy_all`,
this cop will only check cases where the receiver is a model.
It will ignore cases where the receiver is an association (e.g., `user.articles.all.delete_all`).
This is because omitting `all` from an association changes the methods
from `ActiveRecord::Relation` to `ActiveRecord::Associations::CollectionProxy`,
which can affect their behavior.

# Examples

```ruby
# bad
User.all.find(id)
User.all.order(:created_at)
users.all.where(id: ids)
user.articles.all.order(:created_at)

# good
User.find(id)
User.order(:created_at)
users.where(id: ids)
user.articles.order(:created_at)# good
ActionMailer::Preview.all.first
ActiveSupport::TimeZone.all.first
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RedundantActiveRecordAllMethod)