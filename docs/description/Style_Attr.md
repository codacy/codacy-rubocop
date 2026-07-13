
Checks for uses of `Module#attr`. The `attr` method has confusing
behavior: with a single argument it creates a reader (like `attr_reader`),
but with a second boolean argument it creates an accessor (deprecated in
Ruby 1.9). Use `attr_reader` or `attr_accessor` to make intent explicit.

# Examples

```ruby
# bad
attr :something, true
attr :one, :two, :three # behaves as attr_reader

# good
attr_accessor :something
attr_reader :one, :two, :three
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Attr)