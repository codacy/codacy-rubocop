
This cop enforces that `ActiveRecord#find` is used instead of
`where.take!`, `find_by!`, and `find_by_id!` to retrieve a single record
by primary key when you expect it to be found.

# Examples

```ruby
# bad
User.where(id: id).take!
User.find_by_id!(id)
User.find_by!(id: id)

# good
User.find(id)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FindById)