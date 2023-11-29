
Check for repeated description strings in example groups.

# Examples

```ruby
# bad
RSpec.describe User do
  it 'is valid' do
    # ...
  end

  it 'is valid' do
    # ...
  end
end

# good
RSpec.describe User do
  it 'is valid when first and last name are present' do
    # ...
  end

  it 'is valid when last name only is present' do
    # ...
  end
end

# good
RSpec.describe User do
  it 'is valid' do
    # ...
  end

  it 'is valid', :flag do
    # ...
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/RepeatedDescription)