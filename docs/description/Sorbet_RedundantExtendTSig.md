
Forbids the use of redundant `extend T::Sig`. Only for use in
applications that monkey patch `Module.include(T::Sig)` globally,
which would make it redundant.

# Examples

```ruby
# bad
class Example
  extend T::Sig
  sig { void }
  def no_op; end
end

# good
class Example
  sig { void }
  def no_op; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/RedundantExtendTSig)