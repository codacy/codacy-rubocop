
Identifies places where `Concurrent.monotonic_time`
can be replaced by `Process.clock_gettime(Process::CLOCK_MONOTONIC)`.

# Examples

```ruby

# bad
Concurrent.monotonic_time

# good
Process.clock_gettime(Process::CLOCK_MONOTONIC)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ConcurrentMonotonicTime)