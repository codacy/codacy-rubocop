
Checks if an example contains any expectation.

All RSpec's example and expectation methods are covered by default.
If you are using your own custom methods,
add the following configuration:

  RSpec:
    Language:
      Examples:
        Regular:
          - custom_it
      Expectations:
        - custom_expect

This cop can be customized with an allowed expectation methods pattern
with an `AllowedPatterns` option. ^expect_ and ^assert_ are allowed
by default.

# Examples

```ruby
# bad
it do
  a?
end

# good
it do
  expect(a?).to be(true)
end
# .rubocop.yml
# RSpec/NoExpectationExample:
#   AllowedPatterns:
#     - ^expect_
#     - ^assert_# bad
it do
  not_expect_something
end

# good
it do
  expect_something
end

it do
  assert_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/NoExpectationExample)