
Identifies places where `pluck` is used in `where` query methods
and can be replaced with `select`.

Since `pluck` is an eager method and hits the database immediately,
using `select` helps to avoid additional database queries by running as
a subquery.

This cop has two modes of enforcement. When the `EnforcedStyle` is set
to `conservative` (the default), only calls to `pluck` on a constant
(e.g. a model class) within `where` are considered offenses.

# Examples

```ruby
# bad
Post.where(user_id: User.active.pluck(:id))
Post.where(user_id: User.active.ids)
Post.where.not(user_id: User.active.pluck(:id))

# good
Post.where(user_id: User.active.select(:id))
Post.where(user_id: active_users.select(:id))
Post.where.not(user_id: active_users.select(:id))# good
Post.where(user_id: active_users.pluck(:id))# bad
Post.where(user_id: active_users.pluck(:id))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/PluckInWhere)