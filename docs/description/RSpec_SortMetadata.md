
Sort RSpec metadata alphabetically.

# Examples

```ruby
# bad
describe 'Something', :b, :a
context 'Something', foo: 'bar', baz: true
it 'works', :b, :a, foo: 'bar', baz: true

# good
describe 'Something', :a, :b
context 'Something', baz: true, foo: 'bar'
it 'works', :a, :b, baz: true, foo: 'bar'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SortMetadata)