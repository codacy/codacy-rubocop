
Looks for places where a subset of an Enumerable (array,
range, set, etc.; see note below) is calculated based on a class type
check, and suggests `grep` or `grep_v` instead.

NOTE: Hashes do not behave as you may expect with `grep`, which
means that `hash.grep` is not equivalent to `hash.select`. Although
RuboCop is limited by static analysis, this cop attempts to avoid
registering an offense when the receiver is a hash (hash literal,
`Hash.new`, `Hash#[]`, or `to_h`/`to_hash`).

# Examples

```ruby
# bad (select or find_all)
array.select { |x| x.is_a?(Foo) }
array.select { |x| x.kind_of?(Foo) }

# bad (reject)
array.reject { |x| x.is_a?(Foo) }

# bad (negative form)
array.reject { |x| !x.is_a?(Foo) }

# good
array.grep(Foo)
array.grep_v(Foo)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SelectByKind)