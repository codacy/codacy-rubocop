
Checks for the ordering of keyword arguments required by
sorbet-runtime. The ordering requires that all keyword arguments
are at the end of the parameters list, and all keyword arguments
with a default value must be after those without default values.

# Examples

```ruby

# bad
sig { params(a: Integer, b: String).void }
def foo(a: 1, b:); end

# good
sig { params(b: String, a: Integer).void }
def foo(b:, a: 1); end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/KeywordArgumentOrdering)