
This cop checks for multiple expressions placed on the same line.
It also checks for lines terminated with a semicolon.

This cop has `AllowAsExpressionSeparator` configuration option.
It allows `;` to separate several expressions on the same line.

# Examples

```ruby
# bad
foo = 1; bar = 2;
baz = 3;

# good
foo = 1
bar = 2
baz = 3# bad
foo = 1; bar = 2# good
foo = 1; bar = 2
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Semicolon)