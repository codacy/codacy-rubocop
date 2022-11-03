
Identifies calls to `where.not` with multiple hash arguments.

The behavior of `where.not` changed in Rails 6.1. Prior to the change,
`.where.not(trashed: true, role: 'admin')` evaluated to
`WHERE trashed != TRUE AND role != 'admin'`.
From Rails 6.1 onwards, this executes the query
`WHERE NOT (trashed == TRUE AND roles == 'admin')`.

# Examples

```ruby
# bad
User.where.not(trashed: true, role: 'admin')
User.where.not(trashed: true, role: ['moderator', 'admin'])
User.joins(:posts).where.not(posts: { trashed: true, title: 'Rails' })

# good
User.where.not(trashed: true)
User.where.not(role: ['moderator', 'admin'])
User.where.not(trashed: true).where.not(role: ['moderator', 'admin'])
User.where.not('trashed = ? OR role = ?', true, 'admin')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/WhereNotWithMultipleConditions)