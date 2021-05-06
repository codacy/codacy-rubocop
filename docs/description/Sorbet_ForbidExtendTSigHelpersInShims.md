
This cop ensures RBI shims do not include a call to extend T::Sig
or to extend T::Helpers

# Examples

```ruby

# bad
module SomeModule
  extend T::Sig
  extend T::Helpers

  sig { returns(String) }
  def foo; end
end

# good
module SomeModule
  sig { returns(String) }
  def foo; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidExtendTSigHelpersInShims)