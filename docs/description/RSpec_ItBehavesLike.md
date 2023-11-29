
Checks that only one `it_behaves_like` style is used.

# Examples

```ruby
# bad
it_should_behave_like 'a foo'

# good
it_behaves_like 'a foo'# bad
it_behaves_like 'a foo'

# good
it_should_behave_like 'a foo'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ItBehavesLike)