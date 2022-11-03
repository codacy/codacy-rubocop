
Identifies places where manually constructed SQL
in `where` can be replaced with `where.not(...)`.

# Examples

```ruby
# bad
User.where('name != ?', 'Gabe')
User.where('name != :name', name: 'Gabe')
User.where('name <> ?', 'Gabe')
User.where('name <> :name', name: 'Gabe')
User.where('name IS NOT NULL')
User.where('name NOT IN (?)', ['john', 'jane'])
User.where('name NOT IN (:names)', names: ['john', 'jane'])
User.where('users.name != :name', name: 'Gabe')

# good
User.where.not(name: 'Gabe')
User.where.not(name: nil)
User.where.not(name: ['john', 'jane'])
User.where.not(users: { name: 'Gabe' })
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/WhereNot)