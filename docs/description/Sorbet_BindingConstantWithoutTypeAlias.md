
This cop disallows binding the return value of `T.any`, `T.all`, `T.enum`
to a constant directly. To bind the value, one must use `T.type_alias`.

# Examples

```ruby

# bad
FooOrBar = T.any(Foo, Bar)

# good
FooOrBar = T.type_alias { T.any(Foo, Bar) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/BindingConstantWithoutTypeAlias)