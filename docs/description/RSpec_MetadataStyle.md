
Use consistent metadata style.

This cop does not support autocorrection in the case of
`EnforcedStyle: hash` where the trailing metadata type is ambiguous.
(e.g. `describe 'Something', :a, b`)

# Examples

```ruby
# bad
describe 'Something', a: true

# good
describe 'Something', :a# bad
describe 'Something', :a

# good
describe 'Something', a: true
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MetadataStyle)