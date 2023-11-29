
Checks if there is a let/subject that overwrites an existing one.

# Examples

```ruby
# bad
let(:foo) { bar }
let(:foo) { baz }

subject(:foo) { bar }
let(:foo) { baz }

let(:foo) { bar }
let!(:foo) { baz }

# good
subject(:test) { something }
let(:foo) { bar }
let(:baz) { baz }
let!(:other) { other }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/OverwritingSetup)