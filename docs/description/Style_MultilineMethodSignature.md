
This cop checks for method signatures that span multiple lines.

# Examples

```ruby

# good

def foo(bar, baz)
end

# bad

def foo(bar,
        baz)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineMethodSignature)