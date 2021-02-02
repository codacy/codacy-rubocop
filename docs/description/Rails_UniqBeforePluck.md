
Prefer the use of distinct, before pluck instead of after.

The use of distinct before pluck is preferred because it executes within
the database.

This cop has two different enforcement modes. When the EnforcedStyle
is conservative (the default) then only calls to pluck on a constant
(i.e. a model class) before distinct are added as offenses.

When the EnforcedStyle is aggressive then all calls to pluck before
distinct are added as offenses. This may lead to false positives
as the cop cannot distinguish between calls to pluck on an
ActiveRecord::Relation vs a call to pluck on an
ActiveRecord::Associations::CollectionProxy.

This cop is unsafe because the behavior may change depending on the
database collation.
Autocorrect is disabled by default for this cop since it may generate
false positives.

# Examples

```ruby
# bad
Model.pluck(:id).uniq

# good
Model.distinct.pluck(:id)# bad
# this will return a Relation that pluck is called on
Model.where(cond: true).pluck(:id).uniq

# bad
# an association on an instance will return a CollectionProxy
instance.assoc.pluck(:id).uniq

# bad
Model.pluck(:id).uniq

# good
Model.distinct.pluck(:id)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UniqBeforePluck)