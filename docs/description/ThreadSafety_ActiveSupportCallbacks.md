
Avoid mutating ActiveSupport callback chains at runtime.

Calls such as `User.skip_callback` and `User.set_callback` mutate callback
chains at process scope.

# Examples

```ruby
# bad
Site.skip_callback(:commit, :after, :after_owner_change)

# bad
Site.set_callback(
  :commit, :after, :after_owner_change,
  if: :saved_change_to_owner?
)

# good
class User < ApplicationRecord
  skip_callback :commit, :after, :after_owner_change
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/ActiveSupportCallbacks)