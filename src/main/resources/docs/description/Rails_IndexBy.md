
This cop looks for uses of `each_with_object({}) { ... }`,
`map { ... }.to_h`, and `Hash[map { ... }]` that are transforming
an enumerable into a hash where the values are the original elements.
Rails provides the `index_by` method for this purpose.

# Examples

```ruby
# bad
[1, 2, 3].each_with_object({}) { |el, h| h[foo(el)] = el }
[1, 2, 3].map { |el| [foo(el), el] }.to_h
Hash[[1, 2, 3].collect { |el| [foo(el), el] }]

# good
[1, 2, 3].index_by { |el| foo(el) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/IndexBy)