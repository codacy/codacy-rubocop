
Avoid starting new threads.

Let a framework like Sidekiq handle the threads.

# Examples

```ruby
# bad
Thread.new { do_work }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/NewThread)