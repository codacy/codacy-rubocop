
Avoid chaining `find` methods and combine selectors.

Combining selectors into a single `find` call is more efficient than
chaining multiple `find` calls, as it reduces the number of DOM queries.
Only recognizable Capybara finder chains with string locators are
checked.
Set `DefaultSelector` to match `Capybara.default_selector`, or to
`null` if it varies at runtime. Autocorrection requires `css` and
literal strings.

# Examples

```ruby
# bad
page.find('#foo').find('.bar')
page.find('#foo').find('.bar').find('.baz')

# good
page.find('#foo .bar')
page.find('#foo .bar .baz')
find('#form').find(:button, 'Save')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/ChainedFind)