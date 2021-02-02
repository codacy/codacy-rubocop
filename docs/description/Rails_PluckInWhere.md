
This cop identifies places where `pluck` is used in `where` query methods
and can be replaced with `select`.

Since `pluck` is an eager method and hits the database immediately,
using `select` helps to avoid additional database queries.

This cop has two different enforcement modes. When the EnforcedStyle
is conservative (the default) then only calls to `pluck` on a constant
(i.e. a model class) in the `where` is used as offenses.

When the EnforcedStyle is aggressive then all calls to `pluck` in the
`where` is used as offenses. This may lead to false positives
as the cop cannot replace to `select` between calls to `pluck` on an
`ActiveRecord::Relation` instance vs a call to `pluck` on an `Array` instance.

# Examples

```ruby
# bad
Post.where(user_id: User.active.pluck(:id))

# good
Post.where(user_id: User.active.select(:id))
Post.where(user_id: active_users.select(:id))# good
Post.where(user_id: active_users.pluck(:id))# bad
Post.where(user_id: active_users.pluck(:id))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/PluckInWhere)