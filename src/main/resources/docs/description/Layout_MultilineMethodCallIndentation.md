
This cop checks the indentation of the method name part in method calls
that span more than one line.

# Examples

```ruby
# bad
while myvariable
.b
  # do something
end

# good
while myvariable
      .b
  # do something
end

# good
Thing.a
     .b
     .c# good
while myvariable
  .b

  # do something
end# good
while myvariable
        .a
        .b

  # do something
end

# good
myvariable = Thing
               .a
               .b
               .c
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/MultilineMethodCallIndentation)