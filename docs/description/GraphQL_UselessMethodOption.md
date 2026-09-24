
This cop detects `resolver_method:` or `method:` options that have no
 effect, either because:

 - the same field also sets `resolver:` -- graphql-ruby always calls
   the resolver class's own resolver_method once `resolver:` is set,
   silently ignoring both `resolver_method:` and `method:` regardless
   of whether a method by either name exists; or
 - a method matching the field's own plain name is also defined on the
   type -- that method is checked (and wins) before `method:` is ever
   considered, since `method:` is only consulted as a fallback when no
   such method exists. This only applies to `method:`: `resolver_method:`
   redirects which name is checked instead of competing with it, so it
   can't be shadowed by a same-named `def` the way `method:` can.

# Examples

```ruby
# good

class Types::PostType < Types::BaseObject
  field :author, resolver: Resolvers::AuthorResolver
end

class Types::PostType < Types::BaseObject
  field :author, String, null: true, method: :ghostwriter
end

# bad

class Types::PostType < Types::BaseObject
  field :author, resolver: Resolvers::AuthorResolver, resolver_method: :fetch_author
end

class Types::PostType < Types::BaseObject
  field :author, resolver: Resolvers::AuthorResolver, method: :ghostwriter
end

class Types::PostType < Types::BaseObject
  field :author, String, null: true, method: :ghostwriter

  def author
    object.author
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/UselessMethodOption)