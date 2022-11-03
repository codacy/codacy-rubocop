
Checks for places where ordering by `id` column is used.

Don't use the `id` column for ordering. The sequence of ids is not guaranteed
to be in any particular order, despite often (incidentally) being chronological.
Use a timestamp column to order chronologically. As a bonus the intent is clearer.

NOTE: Make sure the changed order column does not introduce performance
bottlenecks and appropriate database indexes are added.

# Examples

```ruby
# bad
scope :chronological, -> { order(id: :asc) }
scope :chronological, -> { order(primary_key => :asc) }

# good
scope :chronological, -> { order(created_at: :asc) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/OrderById)