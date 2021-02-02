
Checks for uses of while with a negated condition.

# Examples

```ruby
# bad
while !foo
  bar
end

# good
until foo
  bar
end

# bad
bar until !foo

# good
bar while foo
bar while !foo && baz
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NegatedWhile)