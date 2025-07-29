
Enforces the use of `pluck` over `map`.

`pluck` can be used instead of `map` to extract a single key from each
element in an enumerable. When called on an Active Record relation, it
results in a more efficient query that only selects the necessary key.

NOTE: If the receiver's relation is not loaded and `pluck` is used inside an iteration,
it may result in N+1 queries because `pluck` queries the database on each iteration.
This cop ignores offenses for `map/collect` when they are suspected to be part of an iteration
to prevent such potential issues.

[source,ruby]
----
users = User.all
5.times do
  users.map { |user| user[:foo] } # Only one query is executed
end

users = User.all
5.times do
  users.pluck(:id) # A query is executed on every iteration
end
----

# Examples

```ruby
# bad
Post.published.map { |post| post[:title] }
[{ a: :b, c: :d }].collect { |el| el[:a] }

# good
Post.published.pluck(:title)
[{ a: :b, c: :d }].pluck(:a)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Pluck)