
Identifies places where Array and Hash literals are used within loops.
It is better to extract them into a local variable or constant
to avoid unnecessary allocations on each iteration.

You can set the minimum number of elements to consider
an offense with `MinSize`.

NOTE: Since Ruby 3.4, certain simple arguments to `Array#include?` are
optimized directly in Ruby. This avoids allocations without changing the
code, as such no offense will be registered in those cases. Currently that
includes: strings, `self`, local variables, instance variables, and method
calls without arguments. Additionally, any number of methods can be chained:
`[1, 2, 3].include?(@foo)` and `[1, 2, 3].include?(@foo.bar.baz)` both avoid
the array allocation.

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