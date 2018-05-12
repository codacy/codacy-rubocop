
This cop checks whether method definitions are
separated by one empty line.

`NumberOfEmptyLines` can be and integer (e.g. 1 by default) or
an array (e.g. [1, 2]) to specificy a minimum and a maximum of
empty lines.

`AllowAdjacentOneLineDefs` can be used to configure is adjacent
one line methods definitions are an offense

# Examples

```ruby

# bad
def a
end
def b
end
# good
def a
end

def b
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLineBetweenDefs)