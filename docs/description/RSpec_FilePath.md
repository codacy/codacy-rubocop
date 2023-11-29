
Checks that spec file paths are consistent and well-formed.

This cop is deprecated.
We plan to remove it in the next major version update to 3.0.
The migration targets are `RSpec/SpecFilePathSuffix`
and `RSpec/SpecFilePathFormat`.
If you are using this cop, please plan for migration.

By default, this checks that spec file paths are consistent with the
test subject and enforces that it reflects the described
class/module and its optionally called out method.

With the configuration option `IgnoreMethods` the called out method will
be ignored when determining the enforced path.

With the configuration option `CustomTransform` modules or classes can
be specified that should not as usual be transformed from CamelCase to
snake_case (e.g. 'RuboCop' => 'rubocop' ).

With the configuration option `SpecSuffixOnly` test files will only
be checked to ensure they end in '_spec.rb'. This option disables
checking for consistency in the test subject or test methods.

# Examples

```ruby
# bad
whatever_spec.rb         # describe MyClass

# bad
my_class_spec.rb         # describe MyClass, '#method'

# good
my_class_spec.rb         # describe MyClass

# good
my_class_method_spec.rb  # describe MyClass, '#method'

# good
my_class/method_spec.rb  # describe MyClass, '#method'# bad
whatever_spec.rb         # describe MyClass

# good
my_class_spec.rb         # describe MyClass

# good
my_class_spec.rb         # describe MyClass, '#method'# good
whatever_spec.rb         # describe MyClass

# good
my_class_spec.rb         # describe MyClass

# good
my_class_spec.rb         # describe MyClass, '#method'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/FilePath)