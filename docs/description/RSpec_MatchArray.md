
Checks where `match_array` is used.

This cop checks for the following:
- Prefer `contain_exactly` when matching an array with values.
- Prefer `eq` when using `match_array` with an empty array literal.

# Examples

```ruby
# bad
it { is_expected.to match_array([content1, content2]) }

# good
it { is_expected.to contain_exactly(content1, content2) }

# good
it { is_expected.to match_array([content] + array) }

# good
it { is_expected.to match_array(%w(tremble in fear foolish mortals)) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MatchArray)