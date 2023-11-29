
Checks for consistent verified double reference style.

Only investigates references that are one of the supported styles.

This cop can be configured in your configuration using the
`EnforcedStyle` option and supports `--auto-gen-config`.

# Examples

```ruby
# bad
let(:foo) do
  instance_double('ClassName', method_name: 'returned_value')
end

# good
let(:foo) do
  instance_double(ClassName, method_name: 'returned_value')
end# bad
let(:foo) do
  instance_double(ClassName, method_name: 'returned_value')
end

# good
let(:foo) do
  instance_double('ClassName', method_name: 'returned_value')
end
# good
let(:foo) do
  instance_double(@klass, method_name: 'returned_value')
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/VerifiedDoubleReference)