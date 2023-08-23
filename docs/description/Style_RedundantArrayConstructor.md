
Checks for the instantiation of array using redundant `Array` constructor.
Autocorrect replaces to array literal which is the simplest and fastest.

# Examples

```ruby

# bad
Array.new([])
Array[]
Array([])
Array.new(['foo', 'foo', 'foo'])
Array['foo', 'foo', 'foo']
Array(['foo', 'foo', 'foo'])

# good
[]
['foo', 'foo', 'foo']
Array.new(3, 'foo')
Array.new(3) { 'foo' }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantArrayConstructor)