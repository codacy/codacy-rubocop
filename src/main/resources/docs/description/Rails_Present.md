
This cop checks for code that can be written with simpler conditionals
using `Object#present?` defined by Active Support.

simpler conditionals.

# Examples

```ruby
# Converts usages of `!nil? && !empty?` to `present?`

# bad
!foo.nil? && !foo.empty?

# bad
foo != nil && !foo.empty?

# good
foo.present?# Converts usages of `!blank?` to `present?`

# bad
!foo.blank?

# bad
not foo.blank?

# good
foo.present?# Converts usages of `unless blank?` to `if present?`

# bad
something unless foo.blank?

# good
something if foo.present?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Present)