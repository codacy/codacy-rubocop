
Check for `specify` with `is_expected` and one-liner expectations.

# Examples

```ruby
# bad
specify { is_expected.to be_truthy }

# good
it { is_expected.to be_truthy }

# good
specify do
  # ...
end
specify { expect(sqrt(4)).to eq(2) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/IsExpectedSpecify)