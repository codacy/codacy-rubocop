
Checks that ActiveRecord aliases are not used. The direct method names
are more clear and easier to read.

# Examples

```ruby
#bad
Book.update_attributes!(author: 'Alice')

#good
Book.update!(author: 'Alice')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActiveRecordAliases)