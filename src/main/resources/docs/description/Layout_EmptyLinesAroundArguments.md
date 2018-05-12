
This cops checks if empty lines exist around the arguments
of a method invocation.

# Examples

```ruby
# bad
do_something(
  foo

)

process(bar,

        baz: qux,
        thud: fred)

some_method(

  [1,2,3],
  x: y
)

# good
do_something(
  foo
)

process(bar,
        baz: qux,
        thud: fred)

some_method(
  [1,2,3],
  x: y
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundArguments)