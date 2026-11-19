
Checks positional access to Capybara windows, whose order is undefined.

# Examples

```ruby
# bad
popup = windows.last
original = page.windows.first

# good
popup = window_opened_by { click_link 'Open' }
original = current_window
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/UnorderedWindowAccess)