
Checks for if and unless statements used as modifiers of other if or
unless statements.

# Examples

```ruby

# bad
tired? ? 'stop' : 'go faster' if running?

# bad
if tired?
  "please stop"
else
  "keep going"
end if running?

# good
if running?
  tired? ? 'stop' : 'go faster'
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IfUnlessModifierOfIfUnless)