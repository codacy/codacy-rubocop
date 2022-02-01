
This cop checks for redundant `if` with boolean literal branches.
It checks only conditions to return boolean value (`true` or `false`) for safe detection.
The conditions to be checked are comparison methods, predicate methods, and double negative.

# Examples

```ruby
# bad
if foo == bar
  true
else
  false
end

# bad
foo == bar ? true : false

# good
foo == bar# bad
if foo.do_something?
  true
else
  false
end

# good (but potentially an unsafe correction)
foo.do_something?# good
num.nonzero? ? true : false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IfWithBooleanLiteralBranches)