You should adopt a consistent multi-line method chaining style. There are two popoular styles in the Ruby community,
both of which are considered good -leading . and trailing .

**Leading .** - When continuing a chaining method invocation on another line keep the . on the second line

```
# bad
one.two.three.
  four

# good
one.two.three
  .four
```

**Trailing .** - When continuing a chained method invocation on another line, include the . on the first line to indicate
that the expression continues

```
# bad
one.two.three
  .four

# good
one.two.three.
  four
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/DotPosition)