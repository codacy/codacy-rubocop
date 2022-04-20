
This cop checks for `IO.select` that is incompatible with Fiber Scheduler since Ruby 3.0.

NOTE: When the method is successful the return value of `IO.select` is `[[IO]]`,
and the return value of `io.wait_readable` and `io.wait_writable` are `self`.
They are not auto-corrected when assigning a return value because these types are different.
It's up to user how to handle the return value.

# Examples

```ruby

# bad
IO.select([io], [], [], timeout)

# good
io.wait_readable(timeout)

# bad
IO.select([], [io], [], timeout)

# good
io.wait_writable(timeout)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/IncompatibleIoSelectWithFiberScheduler)