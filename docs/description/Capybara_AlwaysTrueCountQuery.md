
Checks for positive queries that succeed when there are no matches.

# Examples

```ruby
# bad
expect(page).to have_css('.item', minimum: 0)
page.has_css?('.item', minimum: 0)

# good
expect(page).to have_css('.item')
expect(page).to have_css('.item', minimum: 0, maximum: 2)
all('.item', minimum: 0)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/AlwaysTrueCountQuery)