
Use `have_css` or `have_xpath` instead of `have_selector`.

# Examples

```ruby
# bad
expect(foo).to have_selector(:css, 'bar')

# good
expect(foo).to have_css('bar')

# bad
expect(foo).to have_selector(:xpath, 'bar')

# good
expect(foo).to have_xpath('bar')# bad
expect(foo).to have_selector('bar')

# good
expect(foo).to have_css('bar')# bad
expect(foo).to have_selector('bar')

# good
expect(foo).to have_xpath('bar')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/HaveSelector)