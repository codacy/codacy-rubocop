
Identifies usages of `any?`, `empty?` or `none?` predicate methods
chained to `select`/`filter`/`find_all` and change them to use predicate method instead.

# Examples

```ruby
# bad
arr.select { |x| x > 1 }.any?

# good
arr.any? { |x| x > 1 }

# bad
arr.select { |x| x > 1 }.empty?
arr.select { |x| x > 1 }.none?

# good
arr.none? { |x| x > 1 }

# good
relation.select(:name).any?
arr.select { |x| x > 1 }.any?(&:odd?)# good
arr.select { |x| x > 1 }.many?# bad
arr.select { |x| x > 1 }.many?

# good
arr.many? { |x| x > 1 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantFilterChain)