
This cop checks for use of the helper methods which reference
instance variables.

Relying on instance variables makes it difficult to re-use helper
methods.

If it seems awkward to explicitly pass in each dependent
variable, consider moving the behaviour elsewhere, for
example to a model, decorator or presenter.

# Examples

```ruby
# bad
def welcome_message
  "Hello #{@user.name}"
end

# good
def welcome_message(user)
  "Hello #{user.name}"
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/HelperInstanceVariable)