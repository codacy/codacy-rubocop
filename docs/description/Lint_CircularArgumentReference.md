
Checks for circular argument references in optional keyword
arguments and optional ordinal arguments.

NOTE: This syntax was made invalid on Ruby 2.7 - Ruby 3.3 but is allowed
again since Ruby 3.4.

# Examples

```ruby

# bad
def bake(pie: pie)
  pie.heat_up
end

# good
def bake(pie:)
  pie.refrigerate
end

# good
def bake(pie: self.pie)
  pie.feed_to(user)
end

# bad
def cook(dry_ingredients = dry_ingredients)
  dry_ingredients.reduce(&:+)
end

# good
def cook(dry_ingredients = self.dry_ingredients)
  dry_ingredients.combine
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/CircularArgumentReference)