
Checks for expectations on the value of an element found by Capybara.

# Examples

```ruby
# bad
expect(find('input').value).to eq('foobar')
expect(find(:css, 'input').value).to eq('foobar')
expect(find_field('Email').value).to eq('user@example.com')

# good
expect(page).to have_field(with: 'foobar')
expect(page).to have_field('Email', with: 'user@example.com')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/FindElementValueEq)