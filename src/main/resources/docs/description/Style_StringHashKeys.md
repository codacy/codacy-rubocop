
This cop checks for the use of strings as keys in hashes. The use of
symbols is preferred instead.

# Examples

```ruby
# bad
{ 'one' => 1, 'two' => 2, 'three' => 3 }

# good
{ one: 1, two: 2, three: 3 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StringHashKeys)