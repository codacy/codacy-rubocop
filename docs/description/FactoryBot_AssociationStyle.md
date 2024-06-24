
Use a consistent style to define associations.

# Examples

```ruby
# bad
factory :post do
  association :user
end

# good
factory :post do
  user
end

# bad
factory :post do
  association :user, :author
end

# good
factory :post do
  user factory: %i[user author]
end# bad
factory :post do
  user
end

# good
factory :post do
  association :user
end

# bad
factory :post do
  user factory: %i[user author]
end

# good
factory :post do
  association :user, :author
end

# good (NonImplicitAssociationMethodNames: ['email'])
sequence :email do |n|
  "person#{n}@example.com"
end

factory :user do
  email
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/AssociationStyle)