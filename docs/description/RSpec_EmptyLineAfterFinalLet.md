
Checks if there is an empty line after the last let block.

# Examples

```ruby
# bad
let(:foo) { bar }
let(:something) { other }
it { does_something }

# good
let(:foo) { bar }
let(:something) { other }

it { does_something }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyLineAfterFinalLet)