
Avoid opening modules and defining specs within them.

# Examples

```ruby
# bad
module MyModule
  RSpec.describe MyClass do
    # ...
  end
end

# good
RSpec.describe MyModule::MyClass do
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/DescribedClassModuleWrapping)