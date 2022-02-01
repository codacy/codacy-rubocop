
Prefer using `distinct` before `pluck` instead of `uniq` after `pluck`.

The use of distinct before pluck is preferred because it executes by
the database.

This cop has two different enforcement modes. When the EnforcedStyle
is `conservative` (the default), then only calls to `pluck` on a constant
(i.e. a model class) before `uniq` are added as offenses.

When the EnforcedStyle is `aggressive` then all calls to `pluck` before
distinct are added as offenses. This may lead to false positives
as the cop cannot distinguish between calls to `pluck` on an
ActiveRecord::Relation vs a call to pluck on an
ActiveRecord::Associations::CollectionProxy.

# Examples

```ruby
# bad - redundantly fetches duplicate values
Album.pluck(:band_name).uniq

# good
Album.distinct.pluck(:band_name)# bad - redundantly fetches duplicate values
Album.pluck(:band_name).uniq

# bad - redundantly fetches duplicate values
Album.where(year: 1985).pluck(:band_name).uniq

# bad - redundantly fetches duplicate values
customer.favourites.pluck(:color).uniq

# good
Album.distinct.pluck(:band_name)
Album.distinct.where(year: 1985).pluck(:band_name)
customer.favourites.distinct.pluck(:color)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UniqBeforePluck)