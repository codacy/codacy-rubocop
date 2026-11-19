
Use CSS or XPath matchers instead of generic selector matchers.

# Examples

```ruby
# bad
expect(foo).to have_selector(:css, 'bar')
expect(foo).to have_no_selector(:css, 'bar')

# good
expect(foo).to have_css('bar')
expect(foo).to have_no_css('bar')

# bad
expect(foo).to have_selector(:xpath, 'bar')
expect(foo).to have_no_selector(:xpath, 'bar')

# good
expect(foo).to have_xpath('bar')
expect(foo).to have_no_xpath('bar')

# bad
expect(foo).to have_selector('bar')

# good
expect(foo).to have_css('bar')

# bad
expect(foo).to have_selector('bar')

# good
expect(foo).to have_xpath('bar')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/RSpec/HaveSelector)