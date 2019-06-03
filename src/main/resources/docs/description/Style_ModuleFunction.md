
This cop checks for use of `extend self` or `module_function` in a
module.

Supported styles are: module_function, extend_self.

In case there are private methods, the cop won't be activated.
Otherwise, it forces to change the flow of the default code.

These offenses are not safe to auto-correct since there are different
implications to each approach.

# Examples

```ruby
# bad
module Test
  extend self
  # ...
end

# good
module Test
  module_function
  # ...
end# good
module Test
  extend self
  # ...
  private
  # ...
end# bad
module Test
  module_function
  # ...
end

# good
module Test
  extend self
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ModuleFunction)