
This cop checks for blank lines after signatures.

It also suggests an autocorrect

# Examples

```ruby

# bad
sig { void }

def foo; end

# good
sig { void }
def foo; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/EmptyLineAfterSig)