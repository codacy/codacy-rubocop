
Detects types that implement Node interface and not have `.authorized?` check.
Such types can be fetched by ID and therefore should have type level check to
avoid accidental information exposure.

If `.authorized?` is defined in a parent class, you can add parent to the "SafeBaseClasses"
to avoid offenses in children.

This cop also checks the `can_can_action` or `pundit_role` methods that
can be used as part of the Ruby GraphQL Pro.

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

# good

class UserType < BaseType
  implements GraphQL::Types::Relay::Node

  pundit_role :staff

  field :uuid, ID, null: false
end

# good

class UserType < BaseType
  implements GraphQL::Types::Relay::Node

  can_can_action :staff

  field :uuid, ID, null: false
end

# bad

class UserType < BaseType
  implements GraphQL::Types::Relay::Node

  field :uuid, ID, null: false
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/NotAuthorizedNodeType)