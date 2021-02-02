
This cop identifies places where manually constructed SQL
in `where` can be replaced with `where(attribute: value)`.

# Examples

```ruby
# bad
User.where('name = ?', 'Gabe')
User.where('name = :name', name: 'Gabe')
User.where('name IS NULL')
User.where('name IN (?)', ['john', 'jane'])
User.where('name IN (:names)', names: ['john', 'jane'])
User.where('users.name = :name', name: 'Gabe')

# good
User.where(name: 'Gabe')
User.where(name: nil)
User.where(name: ['john', 'jane'])
User.where(users: { name: 'Gabe' })
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/WhereEquals)