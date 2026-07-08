
Prefer symbol arguments over strings in `order` method.

# Examples

```ruby
# bad
User.order('name')
User.order('name DESC')

# good
User.order(:name)
User.order(name: :desc)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/OrderArguments)