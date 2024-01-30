
Sometimes using `dig` method ends up with just a single
argument. In such cases, dig should be replaced with `[]`.

Since replacing `hash&.dig(:key)` with `hash[:key]` could potentially lead to error,
calls to the `dig` method using safe navigation will be ignored.

# Examples

```ruby
# bad
{ key: 'value' }.dig(:key)
[1, 2, 3].dig(0)

# good
{ key: 'value' }[:key]
[1, 2, 3][0]

# good
{ key1: { key2: 'value' } }.dig(:key1, :key2)
[1, [2, [3]]].dig(1, 1)

# good
keys = %i[key1 key2]
{ key1: { key2: 'value' } }.dig(*keys)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SingleArgumentDig)