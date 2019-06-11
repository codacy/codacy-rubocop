
Here we check if the parameters on a multi-line method call or
definition are aligned.

To set the alignment of the first argument, use the cop
FirstParameterIndentation.

# Examples

```ruby
# good

def foo(bar,
        baz)
  123
end

def foo(
  bar,
  baz
)
  123
end

# bad

def foo(bar,
     baz)
  123
end

# bad

def foo(
  bar,
     baz)
  123
end# good

def foo(bar,
  baz)
  123
end

def foo(
  bar,
  baz
)
  123
end

# bad

def foo(bar,
        baz)
  123
end

# bad

def foo(
  bar,
     baz)
  123
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/AlignParameters)