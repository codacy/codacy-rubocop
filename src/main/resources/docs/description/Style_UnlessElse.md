
This cop looks for *unless* expressions with *else* clauses.

# Examples

```ruby
# bad
unless foo_bar.nil?
  # do something...
else
  # do a different thing...
end

# good
if foo_bar.present?
  # do something...
else
  # do a different thing...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/UnlessElse)