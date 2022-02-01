
This cop checks that controllers subclass `ApplicationController`.

# Examples

```ruby

# good
class MyController < ApplicationController
  # ...
end

# bad
class MyController < ActionController::Base
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ApplicationController)