
This cop prevents defining unnecessary resolver methods in cases
 when :hash_key option can be used

# Examples

```ruby
# good

class Types::UserType < Types::BaseObject
  field :phone, String, null: true, hash_key: :home_phone
end

# bad

class Types::UserType < Types::BaseObject
  field :phone, String, null: true

  def phone
    object[:home_phone]
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/FieldHashKey)