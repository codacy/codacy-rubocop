
Checks for places where redundant assignments are made for in place
modification methods.

# Examples

```ruby
# bad
args = args.concat(ary)
hash = hash.merge!(other)

# good
args.concat(foo)
args += foo
hash.merge!(other)

# good
foo.concat(ary)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantSelfAssignment)