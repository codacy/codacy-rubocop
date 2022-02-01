
This cop checks for `IO.select` that is incompatible with Fiber Scheduler since Ruby 3.0.

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