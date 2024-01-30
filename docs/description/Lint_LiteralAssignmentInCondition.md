
Checks for literal assignments in the conditions of `if`, `while`, and `until`.
It emulates the following Ruby warning:

[source,console]
----
$ ruby -we 'if x = true; end'
-e:1: warning: found `= literal' in conditional, should be ==
----

As a lint cop, it cannot be determined if `==` is appropriate as intended,
therefore this cop does not provide autocorrection.

# Examples

```ruby

# bad
if x = 42
  do_something
end

# good
if x == 42
  do_something
end

# good
if x = y
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/LiteralAssignmentInCondition)