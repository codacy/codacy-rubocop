
Checks expectations on `current_url` that bypass Capybara's waiting.

`have_current_path` can match full URLs and waits for navigation.
A regexp needs `url: true` so it matches the full URL, not just the
path. Autocorrection is unsafe because URL parsing and waiting change
comparison behavior.
Dynamic `match` patterns and `include`, `start_with`, and `end_with`
are reported without autocorrection.

# Examples

```ruby
# bad
expect(page.current_url).to eq('https://example.com/login')
expect(current_url).to match(%r{/login})
expect(current_url).to match('login')
expect(page.current_url).to include('/login')

# good
expect(page).to have_current_path('https://example.com/login')
expect(page).to have_current_path(%r{/login}, url: true)
expect(page).to have_current_path(/login/, url: true)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/CurrentUrlExpectation)