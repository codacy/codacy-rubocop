
Check that `sig` is used instead of `T::Sig::WithoutRuntime.sig`.

Good:

```
sig { void }
def foo; end
```

Bad:

```
T::Sig::WithoutRuntime.sig { void }
def foo; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidSigWithoutRuntime)