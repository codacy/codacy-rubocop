
This cop checks for trailing code after the module definition.

# Examples

```ruby
# bad
module Foo extend self
end

# good
module Foo
  extend self
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingBodyOnModule)