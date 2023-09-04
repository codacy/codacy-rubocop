
Disallows using `.override(allow_incompatible: true)`.
Using `allow_incompatible` suggests a violation of the Liskov
Substitution Principle, meaning that a subclass is not a valid
subtype of its superclass. This Cop prevents these design smells
from occurring.

# Examples

```ruby

# bad
sig.override(allow_incompatible: true)

# good
sig.override
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/AllowIncompatibleOverride)