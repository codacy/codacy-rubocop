
Checks for redundant uses of double splat hash braces.

# Examples

```ruby

# bad
do_something(**{foo: bar, baz: qux})

# good
do_something(foo: bar, baz: qux)

# bad
do_something(**{foo: bar, baz: qux}.merge(options))

# good
do_something(foo: bar, baz: qux, **options)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantDoubleSplatHashBraces)