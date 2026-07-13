
Looks for uses of `+_.each_with_object({}) {...}+`,
`+_.map {...}.to_h+`, and `+Hash[_.map {...}]+` that are actually just
transforming the keys of a hash, and tries to use a simpler & faster
call to `transform_keys` instead.
It should only be enabled on Ruby version 2.5 or newer.
(`transform_keys` was added in Ruby 2.5.)

# Examples

```ruby
# bad
{a: 1, b: 2}.each_with_object({}) { |(k, v), h| h[foo(k)] = v }
Hash[{a: 1, b: 2}.collect { |k, v| [foo(k), v] }]
{a: 1, b: 2}.map { |k, v| [k.to_s, v] }.to_h
{a: 1, b: 2}.to_h { |k, v| [k.to_s, v] }
foo.to_h.each_with_object({}) { |(k, v), h| h[k.to_sym] = v }
foo.merge(bar).map { |k, v| [k.to_s, v] }.to_h

# good
{a: 1, b: 2}.transform_keys { |k| foo(k) }
{a: 1, b: 2}.transform_keys { |k| k.to_s }
foo.to_h.transform_keys { |k| k.to_sym }
foo.merge(bar).transform_keys { |k| k.to_s }

# Won't register an offense - receiver is not known to be a hash
foo.bar.each_with_object({}) { |(k, v), h| h[k.to_s] = v }
baz.map { |k, v| [k.to_s, v] }.to_h
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/HashTransformKeys)