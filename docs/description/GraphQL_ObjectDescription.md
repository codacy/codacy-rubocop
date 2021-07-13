
This cop checks if a type (object, input, interface, scalar, union,
 mutation, subscription, and resolver) has a description.

# Examples

```ruby
# good

class Types::UserType < Types::BaseObject
  description "Represents application user"
  # ...
end

# bad

class Types::UserType < Types::BaseObject
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/ObjectDescription)