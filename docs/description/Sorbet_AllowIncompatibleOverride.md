
Disallows incompatible overrides in Sorbet signatures and RBS comments.
Using `allow_incompatible` suggests a violation of the Liskov
Substitution Principle, meaning that a subclass is not a valid
subtype of its superclass. This Cop prevents these design smells
from occurring.

# Examples

```ruby

# bad
sig { override(allow_incompatible: true).void }
def foo; end

# @override(allow_incompatible: true)
#: () -> void
def foo; end

# @override(allow_incompatible: true)
#: String
attr_reader :foo

# good
sig { override.void }

# @override
#: () -> void
def foo; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/AllowIncompatibleOverride)