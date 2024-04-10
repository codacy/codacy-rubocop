
Checks that ActiveRecord aliases are not used. The direct method names
are more clear and easier to read.

# Examples

```ruby
#bad
book.update_attributes!(author: 'Alice')

#good
book.update!(author: 'Alice')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActiveRecordAliases)