
Checks for redundant uses of double splat hash braces.

# Examples

```ruby

# bad
do_something(**{foo: bar, baz: qux})

# good
do_something(foo: bar, baz: qux)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantDoubleSplatHashBraces)