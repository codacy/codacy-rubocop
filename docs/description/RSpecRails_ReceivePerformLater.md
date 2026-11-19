
Prefer `have_enqueued_job` over `receive(:perform_later)`.

The `have_enqueued_job` matcher is preferred for testing ActiveJob
enqueuing. It is more explicit and provides better clarity than
using `receive(:perform_later)`.

# Examples

```ruby
# bad
expect(MyJob).to receive(:perform_later)
do_something

# bad
allow(MyJob).to receive(:perform_later)
do_something
expect(MyJob).to have_received(:perform_later)

# bad
expect(MyJob).to receive(:perform_later).with(user, order)

# good
expect { do_something }.to have_enqueued_job(MyJob)

# good
expect { do_something }.to have_enqueued_job(MyJob).with(user, order)

# good
expect { do_something }
  .to have_enqueued_job(MyJob)
  .on_queue('mailers')
  .at(Date.tomorrow.noon)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/ReceivePerformLater)