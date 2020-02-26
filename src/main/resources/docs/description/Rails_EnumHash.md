
This cop looks for enums written with array syntax.

When using array syntax, adding an element in a
position other than the last causes all previous
definitions to shift. Explicitly specifying the
value for each key prevents this from happening.

# Examples

```ruby
# bad
enum status: [:active, :archived]

# good
enum status: { active: 0, archived: 1 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/EnumHash)