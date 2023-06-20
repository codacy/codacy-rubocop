
Detects types that implement Node interface and not have `.authorized?` check.
Such types can be fetched by ID and therefore should have type level check to
avoid accidental information exposure.

If `.authorized?` is defined in a parent class, you can add parent to the "SafeBaseClasses"
to avoid offenses in children.

# Examples

```ruby
# good

class UserType < BaseType
  implements GraphQL::Types::Relay::Node

  field :uuid, ID, null: false

  def self.authorized?(object, context)
    super && object.owner == context[:viewer]
  end
end

# good

class UserType < BaseType
  implements GraphQL::Types::Relay::Node

  field :uuid, ID, null: false

  class << self
    def authorized?(object, context)
      super && object.owner == context[:viewer]
    end
  end
end

# bad

class UserType < BaseType
  implements GraphQL::Types::Relay::Node

  field :uuid, ID, null: false
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/NotAuthorizedNodeType)