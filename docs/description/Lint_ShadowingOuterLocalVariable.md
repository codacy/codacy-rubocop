
Checks for the use of local variable names from an outer scope
in block arguments or block-local variables. This mirrors the warning
given by `ruby -cw` prior to Ruby 2.6:
"shadowing outer local variable - foo".

The cop is now disabled by default to match the upstream Ruby behavior.
It's useful, however, if you'd like to avoid shadowing variables from outer
scopes, which some people consider an anti-pattern that makes it harder
to keep track of what's going on in a program.

NOTE: Shadowing of variables in block passed to `Ractor.new` is allowed
because `Ractor` should not access outer variables.
eg. following style is encouraged:

[source,ruby]
----
worker_id, pipe = env
Ractor.new(worker_id, pipe) do |worker_id, pipe|
end
----

# Examples

```ruby

# bad
def some_method
  foo = 1

  2.times do |foo| # shadowing outer `foo`
    do_something(foo)
  end
end

# good
def some_method
  foo = 1

  2.times do |bar|
    do_something(bar)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ShadowingOuterLocalVariable)