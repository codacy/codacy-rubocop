
Checks the arguments passed to `before`, `around`, and `after`.

This cop checks for consistent style when specifying RSpec
hooks which run for each example. There are three supported
styles: "implicit", "each", and "example." All styles have
the same behavior.

# Examples

```ruby
# bad
before(:each) do
  # ...
end

# bad
before(:example) do
  # ...
end

# good
before do
  # ...
end# bad
before(:example) do
  # ...
end

# bad
before do
  # ...
end

# good
before(:each) do
  # ...
end# bad
before(:each) do
  # ...
end

# bad
before do
  # ...
end

# good
before(:example) do
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/HookArgument)