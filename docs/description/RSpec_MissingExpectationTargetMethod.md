
Checks if `.to`, `not_to` or `to_not` are used.

The RSpec::Expectations::ExpectationTarget must use `to`, `not_to` or
`to_not` to run. Therefore, this cop checks if other methods are used.

# Examples

```ruby
# bad
expect(something).kind_of? Foo
is_expected == 42
expect{something}.eq? BarError

# good
expect(something).to be_a Foo
is_expected.to eq 42
expect{something}.to raise_error BarError
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MissingExpectationTargetMethod)