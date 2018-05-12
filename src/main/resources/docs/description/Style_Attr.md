
This cop checks for uses of Module#attr.

# Examples

```ruby
# bad - creates a single attribute accessor (deprecated in Ruby 1.9)
attr :something, true
attr :one, :two, :three # behaves as attr_reader

# good
attr_accessor :something
attr_reader :one, :two, :three
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Attr)