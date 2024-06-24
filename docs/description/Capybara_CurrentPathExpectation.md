
Checks that no expectations are set on Capybara's `current_path`.

The
https://www.rubydoc.info/github/teamcapybara/capybara/master/Capybara/RSpecMatchers#have_current_path-instance_method[`have_current_path` matcher]
should be used on `page` to set expectations on Capybara's
current path, since it uses
https://github.com/teamcapybara/capybara/blob/master/README.md#asynchronous-javascript-ajax-and-friends[Capybara's waiting functionality]
which ensures that preceding actions (like `click_link`) have
completed.

This cop does not support autocorrection in some cases.

# Examples

```ruby
# bad
expect(current_path).to eq('/callback')
expect(page.current_path).to eq('/callback')

# good
expect(page).to have_current_path('/callback', ignore_query: true)

# bad (does not support autocorrection when `match` with a variable)
expect(page).to match(variable)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/CurrentPathExpectation)