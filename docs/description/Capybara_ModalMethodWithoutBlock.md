
Checks that modal handling methods are called with a block.

# Examples

```ruby
# bad
accept_confirm
page.accept_prompt(with: 'answer')

# good
accept_confirm { click_button 'Delete' }
page.accept_prompt(with: 'answer', &trigger_modal)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/ModalMethodWithoutBlock)