
Avoid duplicated metadata.

# Examples

```ruby
# bad
describe 'Something', :a, :a

# good
describe 'Something', :a
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/DuplicatedMetadata)