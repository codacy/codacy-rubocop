
Enforces use of `Element#[]` instead of `native.attribute`.

Only calls on Capybara finder chains are checked.

# Examples

```ruby
# bad
find('.item').native.attribute(:id)
page.find('.item').native.attribute('aria-label')

# good
find('.item')[:id]
page.find('.item')['aria-label']
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/NativeAttribute)