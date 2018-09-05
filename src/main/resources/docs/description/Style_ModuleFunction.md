
This cops checks for use of `extend self` or `module_function` in a
module.

Supported styles are: module_function, extend_self.

These offenses are not auto-corrected since there are different
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