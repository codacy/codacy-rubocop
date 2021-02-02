
This cops looks for references of Regexp captures that are out of range
and thus always returns nil.

# Examples

```ruby

/(foo)bar/ =~ 'foobar'

# bad - always returns nil

puts $2 # => nil

# good

puts $1 # => foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/OutOfRangeRegexpRef)