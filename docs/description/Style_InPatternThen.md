
This cop checks for `in;` uses in `case` expressions.

# Examples

```ruby
# bad
case expression
in pattern_a; foo
in pattern_b; bar
end

# good
case expression
in pattern_a then foo
in pattern_b then bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/InPatternThen)