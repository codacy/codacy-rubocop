
Detect redundant `all` used as a receiver for Active Record query methods.

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