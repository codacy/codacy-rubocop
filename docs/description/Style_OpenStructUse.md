
Flags uses of OpenStruct, as it is now officially discouraged
to be used for performance, version compatibility, and potential security issues.

# Examples

```ruby

# bad
point = OpenStruct.new(x: 0, y: 1)

# good
Point = Struct.new(:x, :y)
point = Point.new(0, 1)

# also good
point = { x: 0, y: 1 }

# bad
test_double = OpenStruct.new(a: 'b')

# good (assumes test using rspec-mocks)
test_double = double
allow(test_double).to receive(:a).and_return('b')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/OpenStructUse)