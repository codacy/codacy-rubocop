
Checks for the obsolete pattern for initializing instance variables that was required for older Sorbet
versions in `#typed: strict` files.

It's no longer required, as of Sorbet 0.5.10210
See https://sorbet.org/docs/type-assertions#put-type-assertions-behind-memoization

# Examples

```ruby

# bad
sig { returns(Foo) }
def foo
  @foo = T.let(@foo, T.nilable(Foo))
  @foo ||= Foo.new
end

# bad
sig { returns(Foo) }
def foo
  # This would have been a mistake, causing the memoized value to be discarded and recomputed on every call.
  @foo = T.let(nil, T.nilable(Foo))
  @foo ||= Foo.new
end

# good
sig { returns(Foo) }
def foo
  @foo ||= T.let(Foo.new, T.nilable(Foo))
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ObsoleteStrictMemoization)