
Checks for manual counting patterns that can be replaced by `Enumerable#tally`.

The cop detects the following patterns:

- `each_with_object(Hash.new(0)) { |item, counts| counts[item] += 1 }`
- `group_by(&:itself).transform_values(&:count)`
- `group_by { |x| x }.transform_values(&:size)`
- `group_by { |x| x }.transform_values { |v| v.length }`

# Examples

```ruby
# bad
array.each_with_object(Hash.new(0)) { |item, counts| counts[item] += 1 }

# bad
array.group_by(&:itself).transform_values(&:count)

# bad
array.group_by { |item| item }.transform_values(&:size)

# bad
array.group_by { |item| item }.transform_values { |v| v.length }

# good
array.tally
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TallyMethod)