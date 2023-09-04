
Checks that quotes inside string, symbol, and regexp interpolations
match the configured preference.

# Examples

```ruby
# bad
string = "Tests #{success ? "PASS" : "FAIL"}"
symbol = :"Tests #{success ? "PASS" : "FAIL"}"
heredoc = <<~TEXT
  Tests #{success ? "PASS" : "FAIL"}
TEXT
regexp = /Tests #{success ? "PASS" : "FAIL"}/

# good
string = "Tests #{success ? 'PASS' : 'FAIL'}"
symbol = :"Tests #{success ? 'PASS' : 'FAIL'}"
heredoc = <<~TEXT
  Tests #{success ? 'PASS' : 'FAIL'}
TEXT
regexp = /Tests #{success ? 'PASS' : 'FAIL'}/# bad
string = "Tests #{success ? 'PASS' : 'FAIL'}"
symbol = :"Tests #{success ? 'PASS' : 'FAIL'}"
heredoc = <<~TEXT
  Tests #{success ? 'PASS' : 'FAIL'}
TEXT
regexp = /Tests #{success ? 'PASS' : 'FAIL'}/

# good
string = "Tests #{success ? "PASS" : "FAIL"}"
symbol = :"Tests #{success ? "PASS" : "FAIL"}"
heredoc = <<~TEXT
  Tests #{success ? "PASS" : "FAIL"}
TEXT
regexp = /Tests #{success ? "PASS" : "FAIL"}/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StringLiteralsInInterpolation)