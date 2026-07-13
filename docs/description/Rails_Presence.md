
Checks code that can be written more easily using
`Object#presence` defined by Active Support.

# Examples

```ruby
# bad
a.present? ? a : nil

# bad
!a.present? ? nil : a

# bad
a.blank? ? nil : a

# bad
!a.blank? ? a : nil

# good
a.presence

# bad
a.present? ? a : b

# bad
!a.present? ? b : a

# bad
a.blank? ? b : a

# bad
!a.blank? ? a : b

# good
a.presence || b

# bad
a.present? ? a.foo : nil

# bad
!a.present? ? nil : a.foo

# bad
a.blank? ? nil : a.foo

# bad
!a.blank? ? a.foo : nil

# good
a.presence&.foo

# good
a.present? ? a[1] : nil

# good
a[:key] = value if a.present?

# good
a.present? ? a > 1 : nil
a <= 0 if a.present?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Presence)