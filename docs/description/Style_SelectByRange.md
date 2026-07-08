
Looks for places where a subset of an Enumerable (array,
range, set, etc.; see note below) is calculated based on a range
check, and suggests `grep` or `grep_v` instead.

NOTE: Hashes do not behave as you may expect with `grep`, which
means that `hash.grep` is not equivalent to `hash.select`. Although
RuboCop is limited by static analysis, this cop attempts to avoid
registering an offense when the receiver is a hash (hash literal,
`Hash.new`, `Hash#[]`, or `to_h`/`to_hash`).

# Examples

```ruby
# bad (select or find_all)
array.select { |x| x.between?(1, 10) }
array.select { |x| (1..10).cover?(x) }
array.select { |x| (1..10).include?(x) }

# bad (reject)
array.reject { |x| x.between?(1, 10) }

# bad (find or detect)
array.find { |x| x.between?(1, 10) }
array.detect { |x| (1..10).cover?(x) }

# bad (negative form)
array.reject { |x| !x.between?(1, 10) }
array.find { |x| !(1..10).cover?(x) }

# good
array.grep(1..10)
array.grep_v(1..10)
array.grep(1..10).first
array.grep_v(1..10).first
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SelectByRange)