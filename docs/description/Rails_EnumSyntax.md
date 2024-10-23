
Looks for enums written with keyword arguments syntax.

Defining enums with keyword arguments syntax is deprecated and will be removed in Rails 8.0.
Positional arguments should be used instead:

# Examples

```ruby
# bad
enum status: { active: 0, archived: 1 }, _prefix: true

# good
enum :status, { active: 0, archived: 1 }, prefix: true
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/EnumSyntax)