
Check that definitions do not use a `sig` block.

Good:

```
#: -> void
def foo; end
```

Bad:

```
T::Sig.sig { void }
def foo; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidSigWithRuntime)