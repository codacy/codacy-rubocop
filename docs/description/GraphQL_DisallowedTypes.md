
Flags field and argument types the project has decided not to expose, with a message
explaining what to use instead.

Every schema accumulates types that are still resolvable but shouldn't be reached for
in new code: a scalar kept alive only for backwards compatibility, a type that predates
a better one, or a builtin whose semantics don't fit the domain -- `Float` for money,
say, where the serialization loses precision. The convention is usually documented and
then re-litigated in review; this makes it fail the build instead.

Nothing is disallowed by default: the cop is inert until `Types` is configured.

A configured name matches the written constant exactly, or as a trailing segment of it,
so `Float` covers `Float`, `Types::Float` and `GraphQL::Types::Float`. Configure
`GraphQL::Types::Float` instead to match only the fully qualified form.

List types are unwrapped, so `[Float]` and `[Float, null: true]` are flagged too, and
both the positional type and the `type:` keyword are checked.

# Examples

```ruby
# bad
field :amount, Float, null: false
argument :amount, Float, required: true
field :amounts, [Float], null: false
field :amount, type: Float, null: false

# good
field :amount, Types::Decimal, null: false
argument :amount, Types::Decimal, required: true

# bad
field :starts_on, Types::LegacyDate, null: false

# good
field :starts_on, GraphQL::Types::ISO8601Date, null: false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/DisallowedTypes)