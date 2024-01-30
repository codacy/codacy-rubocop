
Identifies usages of `arr[0]` and `arr[-1]` and suggests to change
them to use `arr.first` and `arr.last` instead.

The cop is disabled by default due to safety concerns.

# Examples

```ruby
# bad
arr[0]
arr[-1]

# good
arr.first
arr.last
arr[0] = 2
arr[0][-2]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ArrayFirstLast)