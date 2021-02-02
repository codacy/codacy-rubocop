
This cop checks for the use of the has_and_belongs_to_many macro.

# Examples

```ruby
# bad
# has_and_belongs_to_many :ingredients

# good
# has_many :ingredients, through: :recipe_ingredients
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/HasAndBelongsToMany)