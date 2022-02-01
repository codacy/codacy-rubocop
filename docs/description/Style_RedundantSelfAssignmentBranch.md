
This cop checks for places where conditional branch makes redundant self-assignment.

It only detects local variable because it may replace state of instance variable,
class variable, and global variable that have state across methods with `nil`.

# Examples

```ruby

# bad
foo = condition ? bar : foo

# good
foo = bar if condition

# bad
foo = condition ? foo : bar

# good
foo = bar unless condition
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantSelfAssignmentBranch)