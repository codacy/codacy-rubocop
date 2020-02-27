
This cop checks that mailers subclass ApplicationMailer with Rails 5.0.

# Examples

```ruby

# good
class MyMailer < ApplicationMailer
  # ...
end

# bad
class MyMailer < ActionMailer::Base
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ApplicationMailer)