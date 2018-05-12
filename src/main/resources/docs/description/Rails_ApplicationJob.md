
This cop checks that jobs subclass ApplicationJob with Rails 5.0.

# Examples

```ruby

# good
class Rails5Job < ApplicationJob
  # ...
end

# bad
class Rails4Job < ActiveJob::Base
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ApplicationJob)