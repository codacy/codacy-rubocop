
Specify the exact target to click on.

In projects where accessibility needs to be considered,
it is crucial to specify the click target precisely.

# Examples

```ruby
# bad
click_link_or_button('foo')
click_on('foo')

# good
click_link('foo')
click_button('foo')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/AmbiguousClick)