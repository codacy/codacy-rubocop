
Checks for redundant calls of `Array#flatten`.

`Array#join` joins nested arrays recursively, so flattening an array
beforehand is redundant.

# Examples

```ruby
# bad
x.flatten.join
x.flatten(1).join

# good
x.join
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantArrayFlatten)