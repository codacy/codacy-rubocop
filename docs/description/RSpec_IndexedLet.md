
Do not set up test data using indexes (e.g., `item_1`, `item_2`).

It makes reading the test harder because it's not clear what exactly
is tested by this particular example.

The configurable options `AllowedIdentifiers` and `AllowedPatterns`
will also read those set in `Naming/VariableNumber`.

# Examples

```ruby
# bad
let(:item_1) { create(:item) }
let(:item_2) { create(:item) }

let(:item1) { create(:item) }
let(:item2) { create(:item) }

# good

let(:visible_item) { create(:item, visible: true) }
let(:invisible_item) { create(:item, visible: false) }# bad
let(:item_1) { create(:item) }
let(:item_2) { create(:item) }
let(:item_3) { create(:item) }

# good
let(:item_1) { create(:item) }
let(:item_2) { create(:item) }# good
let(:item_1) { create(:item) }
let(:item_2) { create(:item) }# good
let(:item_1) { create(:item) }
let(:item_2) { create(:item) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/IndexedLet)