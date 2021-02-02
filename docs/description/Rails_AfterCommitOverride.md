
This cop enforces that there is only one call to `after_commit`
(and its aliases - `after_create_commit`, `after_update_commit`,
and `after_destroy_commit`) with the same callback name per model.

# Examples

```ruby
# bad
# This won't be triggered.
after_create_commit :log_action

# This will override the callback added by
# after_create_commit.
after_update_commit :log_action

# bad
# This won't be triggered.
after_commit :log_action, on: :create
# This won't be triggered.
after_update_commit :log_action
# This will override both previous callbacks.
after_commit :log_action, on: :destroy

# good
after_save_commit :log_action

# good
after_create_commit :log_create_action
after_update_commit :log_update_action
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/AfterCommitOverride)