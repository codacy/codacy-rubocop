
This cop checks for duplicated instance (or singleton) method
definitions.

# Examples

```ruby

# bad

def foo
  1
end

def foo
  2
end
# bad

def foo
  1
end

alias foo bar
# good

def foo
  1
end

def bar
  2
end
# good

def foo
  1
end

alias bar foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateMethods)