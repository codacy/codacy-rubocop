
Checks for nested example groups.

This cop is configurable using the `Max` option
and supports `--auto-gen-config`.

# Examples

```ruby
# bad
context 'when using some feature' do
  let(:some)    { :various }
  let(:feature) { :setup   }

  context 'when user is signed in' do  # flagged by rubocop
    let(:user) do
      UserCreate.call(user_attributes)
    end

    let(:user_attributes) do
      {
        name: 'John',
        age:  22,
        role: role
      }
    end

    context 'when user is an admin' do # flagged by rubocop
      let(:role) { 'admin' }

      it 'blah blah'
      it 'yada yada'
    end
  end
end

# good
context 'using some feature as an admin' do
  let(:some)    { :various }
  let(:feature) { :setup   }

  let(:user) do
    UserCreate.call(
      name: 'John',
      age:  22,
      role: 'admin'
    )
  end

  it 'blah blah'
  it 'yada yada'
end# bad
describe Foo do
  context 'foo' do
    context 'bar' do
      context 'baz' do # flagged by rubocop
      end
    end
  end
end# bad
describe Foo do
  context 'foo' do
    context 'bar' do # flagged by rubocop
      context 'baz' do # flagged by rubocop
      end
    end
  end
enddescribe Foo do # <-- nested groups 1
  context 'foo' do # <-- nested groups 2
    context 'bar' do # <-- nested groups 3
    end
  end
enddescribe Foo do # <-- nested groups 1
  path '/foo' do # <-- nested groups 1 (not counted)
    context 'bar' do # <-- nested groups 2
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/NestedGroups)