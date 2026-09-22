
A non-null field should not have a resolver whose Sorbet signature returns a nilable
type. The two disagree: the schema promises a value, the signature admits `nil`, and
graphql-ruby raises an invalid-null error for every object that resolves to `nil`.

Sorbet cannot catch this, because the field declaration is not part of the signature.
Only the crashing direction is reported: a nullable field with a non-nilable resolver
is merely imprecise, not broken.

Codebases without Sorbet signatures never trigger this cop.

# Examples

```ruby
# bad

class UserType < BaseObject
  field :name, String, null: false

  sig { override.returns(T.nilable(String)) }
  def name
    object.name
  end
end

# good - the schema admits what the resolver may return

class UserType < BaseObject
  field :name, String, null: true

  sig { override.returns(T.nilable(String)) }
  def name
    object.name
  end
end

# good - the resolver guarantees what the schema promises

class UserType < BaseObject
  field :name, String, null: false

  sig { override.returns(String) }
  def name
    object.name || "anonymous"
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/NullabilityMismatch)