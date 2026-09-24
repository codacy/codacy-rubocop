
Optional arguments should have a default value in the resolver signature.

When the client omits an argument declared `required: false`, graphql-ruby leaves it
out of the keyword arguments entirely, so a required keyword raises
`ArgumentError: missing keyword`. Giving the keyword a default value is what makes the
argument actually optional at runtime.

Arguments declared with a `default_value:` are always passed, so they are not reported.
Neither is `required: :nullable`, which still demands the argument be present.

Both class-level arguments (checked against `#resolve` and `#authorized?`) and
arguments defined inside a field block (checked against that field's resolver method)
are covered.

# Examples

```ruby
# bad

class SomeResolver < Resolvers::Base
  argument :name, String, required: false

  def resolve(name:); end
end

# good

class SomeResolver < Resolvers::Base
  argument :name, String, required: false

  def resolve(name: nil); end
end

# good - a default value means the keyword is always passed

class SomeResolver < Resolvers::Base
  argument :name, String, required: false, default_value: "anonymous"

  def resolve(name:); end
end

# bad

class UserType < BaseObject
  field :posts, [PostType], null: false do
    argument :limit, Integer, required: false
  end

  def posts(limit:); end
end

# good

class UserType < BaseObject
  field :posts, [PostType], null: false do
    argument :limit, Integer, required: false
  end

  def posts(limit: 10); end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/DefaultForOptionalArgument)