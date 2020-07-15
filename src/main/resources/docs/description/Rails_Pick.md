
This cop enforces the use `pick` over `pluck(...).first`.

# Examples

```ruby
# bad
Model.pluck(:a).first
Model.pluck(:a, :b).first

# good
Model.pick(:a)
Model.pick(:a, :b)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Pick)