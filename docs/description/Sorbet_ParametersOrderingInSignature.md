
This cop checks for inconsistent ordering of parameters between the
signature and the method definition. The sorbet-runtime gem raises
when such inconsistency occurs.

# Examples

```ruby

# bad
sig { params(a: Integer, b: String).void }
def foo(b:, a:); end

# good
sig { params(a: Integer, b: String).void }
def foo(a:, b:); end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ParametersOrderingInSignature)