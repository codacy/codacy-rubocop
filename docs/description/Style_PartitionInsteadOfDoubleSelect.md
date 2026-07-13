
Checks for consecutive calls to `select`/`filter`/`find_all` and `reject`
on the same receiver with the same block body, where `partition` could be
used instead. Also detects two `select` or two `reject` calls where one
block negates the other with `!`. Using `partition` reduces two collection
traversals to one.

# Examples

```ruby
# bad
positives = array.select { |x| x > 0 }
negatives = array.reject { |x| x > 0 }

# bad
positives = array.filter { |x| x > 0 }
negatives = array.reject { |x| x > 0 }

# bad
negatives = array.reject { |x| x > 0 }
positives = array.select { |x| x > 0 }

# bad
positives = array.select(&:positive?)
negatives = array.reject(&:positive?)

# bad
positives = array.select(&:positive?)
negatives = array.reject { |x| x.positive? }

# bad
positives = array.select { |x| x.positive? }
non_positives = array.select { |x| !x.positive? }

# good
positives, negatives = array.partition { |x| x > 0 }

# good
positives, non_positives = array.partition { |x| x.positive? }

# good
positives, negatives = array.partition(&:positive?)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/PartitionInsteadOfDoubleSelect)