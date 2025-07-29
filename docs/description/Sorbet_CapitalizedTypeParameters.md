
Ensure type parameters used in generic methods are always capitalized.

# Examples

```ruby

# bad
sig { type_parameters(:x).params(a: T.type_parameter(:x)).void }
def foo(a); end

# good
sig { type_parameters(:X).params(a: T.type_parameter(:X)).void }
def foo(a: 1); end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/CapitalizedTypeParameters)