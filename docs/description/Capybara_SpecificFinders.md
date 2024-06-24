
Checks if there is a more specific finder offered by Capybara.

# Examples

```ruby
# bad
find('#some-id')
find('[id=some-id]')
find(:css, '#some-id')
find(:id, 'some-id')

# good
find_by_id('some-id')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/SpecificFinders)