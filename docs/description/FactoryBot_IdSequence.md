
Do not create a FactoryBot sequence for an id column.

# Examples

```ruby
# bad - can lead to conflicts between FactoryBot and DB sequences
factory :foo do
  sequence :id
end

# good - a non-id column
factory :foo do
  sequence :some_non_id_column
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/IdSequence)