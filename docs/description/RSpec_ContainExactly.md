
Checks where `contain_exactly` is used.

This cop checks for the following:

- Prefer `match_array` when matching array values.
- Prefer `be_empty` when using `contain_exactly` with no arguments.

# Examples

```ruby
# bad
it { is_expected.to contain_exactly(*array1, *array2) }

# good
it { is_expected.to match_array(array1 + array2) }

# good
it { is_expected.to contain_exactly(content, *array) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ContainExactly)