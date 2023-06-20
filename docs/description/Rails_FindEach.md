
Identifies usages of `all.each` and change them to use `all.find_each` instead.

# Examples

```ruby
# bad
User.all.each

# good
User.all.find_each# good
User.order(:foo).each# good
User.order(:foo).each
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FindEach)