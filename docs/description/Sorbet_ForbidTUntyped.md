
This cop disallows using `T.untyped` anywhere.

# Examples

```ruby

# bad
sig { params(my_argument: T.untyped).void }
def foo(my_argument); end

# good
sig { params(my_argument: String).void }
def foo(my_argument); end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ForbidTUntyped)