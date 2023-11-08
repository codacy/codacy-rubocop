
Checks for the correct order of sig builder methods:
- abstract, override, or overridable
- type_parameters
- params
- returns, or void
- soft, checked, or on_failure

 # bad
 sig { returns(Integer).params(x: Integer) }

 # good
 sig { params(x: Integer).returns(Integer) }

# Examples

```ruby
# bad
sig { void.abstract }

# good
sig { abstract.void }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/SignatureBuildOrder)