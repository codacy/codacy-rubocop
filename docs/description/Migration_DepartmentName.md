
Checks that cop names in rubocop:disable comments are given with
department name.

# Examples

```ruby
# bad
# rubocop:disable AbcSize

# good
# rubocop:disable Metrics/AbcSize
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Migration/DepartmentName)