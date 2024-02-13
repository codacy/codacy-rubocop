
Disallows the usage of `.void.checked(:tests)`.

Using `.void` changes the value returned from the method, but only if
runtime type checking is enabled for the method. Methods marked `.void`
will return different values in tests compared with non-test
environments. This is particularly troublesome if branching on the
result of a `.void` method, because the returned value in test code
will be the truthy `VOID` value, while the non-test return value may be
falsy depending on the method's implementation.

- Use `.returns(T.anything).checked(:tests)` to keep the runtime type
  checking for the rest of the parameters.
- Use `.void.checked(:never)` if you are on an older version of Sorbet
  which does not have `T.anything` (meaning versions 0.5.10781 or
  earlier. Versions released after 2023-04-14 include `T.anything`.)

# Examples

```ruby

# bad
sig { void.checked(:tests) }

# good
sig { void }
sig { returns(T.anything).checked(:tests) }
sig { void.checked(:never) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/VoidCheckedTests)