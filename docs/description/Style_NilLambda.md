
This cop checks for lambdas and procs that always return nil,
which can be replaced with an empty lambda or proc instead.

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