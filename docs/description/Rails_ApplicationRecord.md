
This cop checks that models subclass ApplicationRecord with Rails 5.0.

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