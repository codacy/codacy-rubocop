
This cop is used to identify usages of `where.first` and
change them to use `find_by` instead.

# Examples

```ruby
# bad
User.where(name: 'Bruce').first
User.where(name: 'Bruce').take

# good
User.find_by(name: 'Bruce')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FindBy)