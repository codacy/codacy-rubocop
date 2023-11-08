
Checks for the a mistaken variant of the "obsolete memoization pattern" that used to be required
for older Sorbet versions in `#typed: strict` files. The mistaken variant would overwrite the ivar with `nil`
on every call, causing the memoized value to be discarded and recomputed on every call.

This cop will correct it to read from the ivar instead of `nil`, which will memoize it correctly.

The result of this correction will be the "obsolete memoization pattern", which can further be corrected by
the `Sorbet/ObsoleteStrictMemoization` cop.

See `Sorbet/ObsoleteStrictMemoization` for more details.

# Examples

```ruby
# bad
sig { returns(Foo) }
def foo
  # This `nil` is likely a mistake, causing the memoized value to be discarded and recomputed on every call.
  @foo = T.let(nil, T.nilable(Foo))
  @foo ||= some_computation
end

# good
sig { returns(Foo) }
def foo
  # This will now memoize the value as was likely intended, so `some_computation` is only ever called once.
  # ⚠️If `some_computation` has side effects, this might be a breaking change!
  @foo = T.let(@foo, T.nilable(Foo))
  @foo ||= some_computation
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/BuggyObsoleteStrictMemoization)