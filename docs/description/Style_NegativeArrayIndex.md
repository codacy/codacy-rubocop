
Identifies usages of `arr[arr.length - n]`, `arr[arr.size - n]`, or
`arr[arr.count - n]` and suggests to change them to use `arr[-n]` instead.
Also handles range patterns like `arr[0..(arr.length - n)]`.

The cop recognizes preserving methods (`sort`, `reverse`, `shuffle`, `rotate`)
and their combinations, allowing safe replacement when the receiver matches.
It works with variables, instance variables, class variables, and constants.

# Examples

```ruby
# bad
arr[arr.count - 2]
arr[0..(arr.length - 2)]
arr[0...(arr.length - 4)]
arr.sort[arr.reverse.length - 2]
arr.sort.reverse[arr.sort.size - 2]

# good
arr[-2]
arr[0..-2]
arr[0...-4]
arr.sort[-2]
arr.sort.reverse[-2]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NegativeArrayIndex)