
Sort RSpec metadata alphabetically.

Only the trailing metadata is sorted.

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

# good, trailing metadata is sorted
describe 'Something', 'description', :a, :b, :z
context 'Something', :z, variable, :a, :b
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/SortMetadata)