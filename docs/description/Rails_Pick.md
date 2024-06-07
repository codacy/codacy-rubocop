
Enforces the use of `pick` over `pluck(...).first`.

Using `pluck` followed by `first` creates an intermediate array, which
`pick` avoids. When called on an Active Record relation, `pick` adds a
limit to the query so that only one value is fetched from the database.

Note that when `pick` is added to a relation with an existing limit, it
causes a subquery to be added. In most cases this is undesirable, and
care should be taken while resolving this violation.

# Examples

```ruby
# bad
Model.pluck(:a).first
[{ a: :b, c: :d }].pluck(:a, :b).first

# good
Model.pick(:a)
[{ a: :b, c: :d }].pick(:a, :b)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Pick)