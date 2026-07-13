
Checks for local variables from outer scopes used inside examples.

Local variables assigned outside an example but used within it act
as shared state, which can make tests non-deterministic.

# Examples

```ruby
# bad - outside variable used in a hook
user = create(:user)

before { user.update(admin: true) }

# good
let(:user) { create(:user) }

before { user.update(admin: true) }

# bad - outside variable used in an example
user = create(:user)

it 'is persisted' do
  expect(user).to be_persisted
end

# good
let(:user) { create(:user) }

it 'is persisted' do
  expect(user).to be_persisted
end

# also good - assigning the variable within the example
it 'is persisted' do
  user = create(:user)

  expect(user).to be_persisted
end

# bad - outside variable passed to included examples
attrs = ['foo', 'bar']

it_behaves_like 'some examples', attrs

# good
it_behaves_like 'some examples' do
  let(:attrs) { ['foo', 'bar'] }
end

# good - when variable is used only as example description
attribute = 'foo'

it "#{attribute} is persisted" do
  expectations
end

# good - when variable is used only in example metadata
skip_message = 'not yet implemented'

it 'does something', skip: skip_message do
  expectations
end

# good - when variable is used only to include other examples
examples = foo ? 'some examples' : 'other examples'

it_behaves_like examples, another_argument
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/LeakyLocalVariable)