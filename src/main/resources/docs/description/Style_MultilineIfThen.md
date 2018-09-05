
Checks for uses of the `then` keyword in multi-line if statements.

# Examples

```ruby
# bad
# This is considered bad practice.
if cond then
end

# good
# If statements can contain `then` on the same line.
if cond then a
elsif cond then b
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineIfThen)