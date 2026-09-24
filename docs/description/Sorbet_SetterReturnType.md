
Checks that setter methods (methods whose name ends with `=`)
declare a `void` return type, in either a Sorbet `sig` block or an
RBS inline comment signature.

Sorbet requires setter methods to return `void`. Declaring any other
return type violates the setter contract and is rejected by Sorbet
under `#typed: strict` and above.

# Examples

```ruby

# bad
sig { params(name: String).returns(String) }
def name=(name); end

# good
sig { params(name: String).void }
def name=(name); end

# bad
#: (String) -> String
def name=(name); end

# good
#: (String) -> void
def name=(name); end

# bad
#: (
#|   String name
#| ) -> String
def name=(name); end

# good
#: (
#|   String name
#| ) -> void
def name=(name); end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/SetterReturnType)