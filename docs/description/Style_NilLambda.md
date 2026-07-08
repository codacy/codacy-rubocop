
Checks for lambdas and procs that always return nil,
which can be replaced with an empty lambda or proc instead.

NOTE: A `proc` that returns nil via an explicit `return` is allowed,
because in a `proc` `return` exits the enclosing method, so removing it
would change behavior. A lambda is still reported, since there `return`
only exits the lambda itself.

# Examples

```ruby
# bad
-> { nil }

lambda do
  next nil
end

proc { nil }

Proc.new do
  break nil
end

# good
-> {}

lambda do
end

-> (x) { nil if x }

proc {}

Proc.new { nil if x }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NilLambda)