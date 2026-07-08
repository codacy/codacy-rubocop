
Detects writes to the `context` object within GraphQL types.
Writing to `context` mutates shared state across the query execution,
which can lead to unexpected behavior and makes code harder to reason about.

This cop is disabled by default.

# Examples

```ruby
# bad
class UserType < BaseType
  field :name, String, null: false

  def name
    context[:current_user] = object.user
    object.name
  end
end

# bad
class UserType < BaseType
  field :name, String, null: false

  def name
    context.merge!(current_user: object.user)
    object.name
  end
end

# good
class UserType < BaseType
  field :name, String, null: false

  def name
    viewer = context[:current_user]
    object.name
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/ContextWriteInType)