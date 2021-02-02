
This cop checks for the use of `Kernel#eval` and `Binding#eval`.

# Examples

```ruby

# bad

eval(something)
binding.eval(something)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/Eval)