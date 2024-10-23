
Checks that models subclass `ApplicationRecord` with Rails 5.0.

It is a common practice to define models inside migrations in order to retain forward
compatibility by avoiding loading any application code. And so migration files are excluded
by default for this cop.

# Examples

```ruby

# good
class Rails5Model < ApplicationRecord
  # ...
end

# bad
class Rails4Model < ActiveRecord::Base
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ApplicationRecord)