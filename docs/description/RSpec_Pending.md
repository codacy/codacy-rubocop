
Checks for any pending or skipped examples.

# Examples

```ruby
# bad
describe MyClass do
  it "should be true"
end

describe MyClass do
  it "should be true", skip: true do
    expect(1).to eq(2)
  end
end

describe MyClass do
  it "should be true" do
    pending
  end
end

describe MyClass do
  xit "should be true" do
  end
end

# good
describe MyClass do
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Pending)