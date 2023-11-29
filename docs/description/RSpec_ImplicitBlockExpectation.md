
Check that implicit block expectation syntax is not used.

Prefer using explicit block expectations.

# Examples

```ruby
# bad
subject { -> { do_something } }
it { is_expected.to change(something).to(new_value) }

# good
it 'changes something to a new value' do
  expect { do_something }.to change(something).to(new_value)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ImplicitBlockExpectation)