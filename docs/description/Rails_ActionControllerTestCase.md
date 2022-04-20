
Using `ActionController::TestCase`` is discouraged and should be replaced by
`ActionDispatch::IntegrationTest``. Controller tests are too close to the
internals of a controller whereas integration tests mimic the browser/user.

# Examples

```ruby
# bad
class MyControllerTest < ActionController::TestCase
end

# good
class MyControllerTest < ActionDispatch::IntegrationTest
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActionControllerTestCase)