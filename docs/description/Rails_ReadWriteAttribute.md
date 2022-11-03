
Checks for the use of the `read_attribute` or `write_attribute`
methods and recommends square brackets instead.

If an attribute is missing from the instance (for example, when
initialized by a partial `select`) then `read_attribute`
will return nil, but square brackets will raise
an `ActiveModel::MissingAttributeError`.

Explicitly raising an error in this situation is preferable, and that
is why rubocop recommends using square brackets.

When called from within a method with the same name as the attribute,
`read_attribute` and `write_attribute` must be used to prevent an
infinite loop:

# Examples

```ruby

# bad
x = read_attribute(:attr)
write_attribute(:attr, val)

# good
x = self[:attr]
self[:attr] = val
# good
def foo
  bar || read_attribute(:foo)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ReadWriteAttribute)