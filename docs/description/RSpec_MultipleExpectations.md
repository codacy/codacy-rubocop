
Checks if examples contain too many `expect` calls.

This cop is configurable using the `Max` option
and works with `--auto-gen-config`.

# Examples

```ruby
# bad
describe UserCreator do
  it 'builds a user' do
    expect(user.name).to eq("John")
    expect(user.age).to eq(22)
  end
end

# good
describe UserCreator do
  it 'sets the users name' do
    expect(user.name).to eq("John")
  end

  it 'sets the users age' do
    expect(user.age).to eq(22)
  end
end# good - the cop ignores when RSpec aggregates failures
describe UserCreator do
  it 'builds a user', :aggregate_failures do
    expect(user.name).to eq("John")
    expect(user.age).to eq(22)
  end
end# Detected as an offense
describe UserCreator do
  it 'builds a user', aggregate_failures: false do
    expect(user.name).to eq("John")
    expect(user.age).to eq(22)
  end
end# bad
describe UserCreator do
  it 'builds a user' do
    expect(user.name).to eq("John")
    expect(user.age).to eq(22)
  end
end# good
describe UserCreator do
  it 'builds a user' do
    expect(user.name).to eq("John")
    expect(user.age).to eq(22)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/MultipleExpectations)