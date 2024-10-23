
Before Ruby 3.0, interpolated strings followed the frozen string literal
magic comment which sometimes made it necessary to explicitly unfreeze them.
Ruby 3.0 changed interpolated strings to always be unfrozen which makes
unfreezing them redundant.

# Examples

```ruby
# bad
+"#{foo} bar"

# bad
"#{foo} bar".dup

# good
"#{foo} bar"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantInterpolationUnfreeze)