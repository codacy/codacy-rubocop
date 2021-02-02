
This cop checks for usage of the %q/%Q syntax when '' or "" would do.

# Examples

```ruby

# bad
name = %q(Bruce Wayne)
time = %q(8 o'clock)
question = %q("What did you say?")

# good
name = 'Bruce Wayne'
time = "8 o'clock"
question = '"What did you say?"'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantPercentQ)