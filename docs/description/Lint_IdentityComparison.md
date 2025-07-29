
Prefer `equal?` over `==` when comparing `object_id`.

`Object#equal?` is provided to compare objects for identity, and in contrast
`Object#==` is provided for the purpose of doing value comparison.

# Examples

```ruby
# bad
foo.object_id == bar.object_id
foo.object_id != baz.object_id

# good
foo.equal?(bar)
!foo.equal?(baz)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/IdentityComparison)