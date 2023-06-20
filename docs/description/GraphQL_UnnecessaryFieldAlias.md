
This cop prevents defining an unnecessary alias, method, or resolver_method.

# Examples

```ruby
# good

field :name, String, "Name of the user", null: true, alias: :real_name
field :name, String, "Name of the user", null: true, method: :real_name
field :name, String, "Name of the user", null: true, resolver_method: :real_name
field :name, String, "Name of the user", null: true, hash_key: :real_name

# bad

field :name, "Name of the user" String, null: true, alias: :name
field :name, String, "Name of the user", null: true, method: :name
field :name, String, "Name of the user", null: true, resolver_method: :name
field :name, String, "Name of the user", null: true, hash_key: :name
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/UnnecessaryFieldAlias)