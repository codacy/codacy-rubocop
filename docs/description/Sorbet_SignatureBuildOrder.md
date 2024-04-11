
Checks for the correct order of `sig` builder methods.

Options:

* `Order`: The order in which to enforce the builder methods are called.

# Examples

```ruby
# bad
sig { void.abstract }

# good
sig { abstract.void }

# bad
sig { returns(Integer).params(x: Integer) }

# good
sig { params(x: Integer).returns(Integer) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/SignatureBuildOrder)