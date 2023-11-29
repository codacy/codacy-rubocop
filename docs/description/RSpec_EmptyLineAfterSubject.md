
Checks if there is an empty line after subject block.

# Examples

```ruby
# bad
subject(:obj) { described_class }
let(:foo) { bar }

# good
subject(:obj) { described_class }

let(:foo) { bar }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyLineAfterSubject)