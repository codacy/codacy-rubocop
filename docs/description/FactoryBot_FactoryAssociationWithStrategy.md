
Use definition in factory association instead of hard coding a strategy.

# Examples

```ruby
# bad - only works for one strategy
factory :foo do
  profile { create(:profile) }
end

# good - implicit
factory :foo do
  profile
end

# good - explicit
factory :foo do
  association :profile
end

# good - inline
factory :foo do
  profile { association :profile }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/FactoryAssociationWithStrategy)