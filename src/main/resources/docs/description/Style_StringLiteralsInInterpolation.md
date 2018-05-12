
This cop checks that quotes inside the string interpolation
match the configured preference.

# Examples

```ruby
# bad
result = "Tests #{success ? "PASS" : "FAIL"}"

# good
result = "Tests #{success ? 'PASS' : 'FAIL'}"# bad
result = "Tests #{success ? 'PASS' : 'FAIL'}"

# good
result = "Tests #{success ? "PASS" : "FAIL"}"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StringLiteralsInInterpolation)