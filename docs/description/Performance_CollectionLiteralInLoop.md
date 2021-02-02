
This cop identifies places where Array and Hash literals are used
within loops. It is better to extract them into a local variable or constant
to avoid unnecessary allocations on each iteration.

You can set the minimum number of elements to consider
an offense with `MinSize`.

# Examples

```ruby
# bad
users.select do |user|
  %i[superadmin admin].include?(user.role)
end

# good
admin_roles = %i[superadmin admin]
users.select do |user|
  admin_roles.include?(user.role)
end

# good
ADMIN_ROLES = %i[superadmin admin]
...
users.select do |user|
  ADMIN_ROLES.include?(user.role)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/CollectionLiteralInLoop)