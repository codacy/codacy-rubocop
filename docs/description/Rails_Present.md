
Checks for code that can be written with simpler conditionals
using `Object#present?` defined by Active Support.

Interaction with `Style/UnlessElse`:
The configuration of `NotBlank` will not produce an offense in the
context of `unless else` if `Style/UnlessElse` is enabled. This is
to prevent interference between the autocorrection of the two cops.

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