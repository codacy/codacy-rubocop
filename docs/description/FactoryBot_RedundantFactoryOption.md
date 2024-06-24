
Checks for redundant `factory` option.

# Examples

```ruby
# bad
association :user, factory: :user

# good
association :user
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/FactoryBot/RedundantFactoryOption)