
Checks for redundant line continuation.

A line continuation is redundant when removing the backslash does not
change how the program parses: the source is reparsed without the
backslash and the resulting AST is compared to the original. Only
backslashes that are pure noise are reported; backslashes that are
significant — inside strings, for string concatenation, before an
operator or argument that would otherwise start a new statement, and
so on — are left alone, as are backslashes in comments.

# Examples

```ruby
# bad
foo. \
  bar
foo \
  &.bar \
    .baz

# good
foo.
  bar
foo
  &.bar
    .baz

# bad
[foo, \
  bar]
{foo: \
  bar}

# good
[foo,
  bar]
{foo:
  bar}

# bad
foo(bar, \
  baz)

# good
foo(bar,
  baz)

# also good - backslash in string concatenation is not redundant
foo('bar' \
  'baz')

# also good - backslash at the end of a comment is not redundant
foo(bar, # \
  baz)

# also good - backslash at the line following the newline begins with a + or -,
# it is not redundant
1 \
  + 2 \
    - 3

# also good - backslash with newline between the method name and its arguments,
# it is not redundant.
some_method \
  (argument)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantLineContinuation)