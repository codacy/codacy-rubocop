
Checks for trailing comma in argument lists.
The supported styles are:

* `consistent_comma`: Requires a comma after the last argument,
for all parenthesized multi-line method calls with arguments.
* `comma`: Requires a comma after the last argument, but only for
parenthesized method calls where each argument is on its own line.
* `diff_comma`: Requires a comma after the last argument, but only
when that argument is followed by an immediate newline, even if
there is an inline comment on the same line.
* `no_comma`: Requires that there is no comma after the last
argument.

Regardless of style, trailing commas are not allowed in
single-line method calls.

# Examples

```ruby
# bad
method(1, 2,)

# good
method(1, 2)

# good
method(
  1, 2,
  3,
)

# good
method(
  1, 2, 3,
)

# good
method(
  1,
  2,
)

# bad
method(1, 2,)

# good
method(1, 2)

# bad
method(
  1, 2,
  3,
)

# good
method(
  1, 2,
  3
)

# bad
method(
  1, 2, 3,
)

# good
method(
  1, 2, 3
)

# good
method(
  1,
  2,
)

# bad
method(1, 2,)

# good
method(1, 2)

# good
method(
  1, 2,
  3,
)

# good
method(
  1, 2, 3,
)

# good
method(
  1,
  2,
)

# bad
method(1, [
  2,
],)

# good
method(1, [
  2,
])

# bad
object[1, 2,
       3, 4,]

# good
object[1, 2,
       3, 4]

# bad
method(1, 2,)

# bad
object[1, 2,]

# good
method(1, 2)

# good
object[1, 2]

# good
method(
  1,
  2
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrailingCommaInArguments)