
Identifies places where manually constructed SQL
in `where` can be replaced with ranges.

# Examples

```ruby
# bad
User.where('age >= ?', 18)
User.where.not('age >= ?', 18)
User.where('age < ?', 18)
User.where('age >= ? AND age < ?', 18, 21)
User.where('age >= :start', start: 18)
User.where('users.age >= ?', 18)

# good
User.where(age: 18..)
User.where.not(age: 18..)
User.where(age: ...18)
User.where(age: 18...21)
User.where(users: { age: 18.. })

# good
# There are no beginless ranges in ruby.
User.where('age > ?', 18)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/WhereRange)