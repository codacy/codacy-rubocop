
Avoid mutating `ENV`.

Environment variables are process-wide. Mutating them can affect other
threads, requests, jobs, or subprocesses running in the same Ruby
process.

# Examples

```ruby
# bad
ENV['TZ'] = 'UTC'

# bad
ENV.update('FOO' => 'bar')

# good
system({ 'TZ' => 'UTC' }, 'date')

# good
ENV.fetch('TZ', 'UTC')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/EnvMutation)