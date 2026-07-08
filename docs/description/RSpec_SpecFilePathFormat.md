
Checks that spec file paths are consistent and well-formed.

# Examples

```ruby
# bad
whatever_spec.rb         # describe MyClass
my_class_spec.rb         # describe MyClass, '#method'

# good
my_class_spec.rb         # describe MyClass
my_class_method_spec.rb  # describe MyClass, '#method'
my_class/method_spec.rb  # describe MyClass, '#method'# good
rubocop_spec.rb          # describe RuboCop
rspec_spec.rb            # describe RSpec# bad
my_class_spec.rb         # describe MyClass, '#method'# good
my_class_spec.rb         # describe MyClass, '#method'# good
whatever_spec.rb         # describe MyClass, type: :routing do; end# Enable to use ActiveSupport's inflector for custom acronyms
# like HTTP, etc. Set to "default" by default.
# Configure `InflectorPath` with the path to the inflector file.
# The default is ./config/initializers/inflections.rb.
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SpecFilePathFormat)