
This cop detects method definitions that are never called because
 the field's effective `resolver_method` points somewhere else.

 graphql-ruby only ever calls a single method on the type instance:
 the field's `resolver_method` (which is the resolver class's own
 method when `resolver:` is set, the explicit `resolver_method:`
 value when given, or the field name otherwise). Any other
 same-named method left on the type is unreachable:

 - When `resolver:` is set, the resolver class handles resolution
   entirely, so neither the field name, `resolver_method:`, nor
   `method:` (if also given) is ever dispatched to a method on the type.
 - When only `resolver_method:` is set, that name is the one
   actually called -- a leftover method matching the plain field
   name is never reached.

# Examples

```ruby
# good

class Types::PostType < Types::BaseObject
  field :author, resolver: Resolvers::AuthorResolver
end

class Types::PostType < Types::BaseObject
  field :author, String, null: true, resolver_method: :fetch_author

  def fetch_author
    object.author
  end
end

# bad

class Types::PostType < Types::BaseObject
  field :author, resolver: Resolvers::AuthorResolver

  def author
    object.author
  end
end

class Types::PostType < Types::BaseObject
  field :author, String, null: true, resolver_method: :fetch_author

  def author
    object.author
  end

  def fetch_author
    object.author
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/MethodShadowedByResolverMethod)