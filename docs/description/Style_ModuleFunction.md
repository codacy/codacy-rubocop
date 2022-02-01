
This cop checks for use of `extend self` or `module_function` in a
module.

Supported styles are: module_function, extend_self, forbidden. `forbidden`
style prohibits the usage of both styles.

NOTE: the cop won't be activated when the module contains any private methods.

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
end# bad
module Test
  module_function
  # ...
end

# bad
module Test
  extend self
  # ...
end

# bad
module Test
  extend self
  # ...
  private
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ModuleFunction)