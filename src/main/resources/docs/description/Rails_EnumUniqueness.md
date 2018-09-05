
This cop looks for duplicate values in enum declarations.

# Examples

```ruby
# bad
enum status: { active: 0, archived: 0 }

# good
enum status: { active: 0, archived: 1 }

# bad
enum status: [:active, :archived, :active]

# good
enum status: [:active, :archived]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/EnumUniqueness)