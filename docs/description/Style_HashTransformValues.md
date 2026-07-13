
Looks for uses of `+_.each_with_object({}) {...}+`,
`+_.map {...}.to_h+`, and `+Hash[_.map {...}]+` that are actually just
transforming the values of a hash, and tries to use a simpler & faster
call to `transform_values` instead.

# Examples

```ruby
# bad
{a: 1, b: 2}.each_with_object({}) { |(k, v), h| h[k] = foo(v) }
Hash[{a: 1, b: 2}.collect { |k, v| [k, foo(v)] }]
{a: 1, b: 2}.map { |k, v| [k, v * v] }.to_h
{a: 1, b: 2}.to_h { |k, v| [k, v * v] }
foo.to_h.each_with_object({}) { |(k, v), h| h[k] = foo(v) }
foo.merge(bar).map { |k, v| [k, v.to_s] }.to_h

# good
{a: 1, b: 2}.transform_values { |v| foo(v) }
{a: 1, b: 2}.transform_values { |v| v * v }
foo.to_h.transform_values { |v| foo(v) }
foo.merge(bar).transform_values { |v| v.to_s }

# Won't register an offense - receiver is not known to be a hash
foo.bar.each_with_object({}) { |(k, v), h| h[k] = v.to_s }
baz.map { |k, v| [k, v.to_s] }.to_h
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/HashTransformValues)