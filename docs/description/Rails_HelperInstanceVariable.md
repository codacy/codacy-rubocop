
Checks for use of the helper methods which reference
instance variables.

Relying on instance variables makes it difficult to reuse helper
methods.

If it seems awkward to explicitly pass in each dependent
variable, consider moving the behavior elsewhere, for
example to a model, decorator or presenter.

Provided that an instance variable belongs to a class,
an offense will not be registered.

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

# good
module ButtonHelper
  class Welcome
    def initialize(text:)
      @text = text
    end
  end

  def welcome(**)
    render Welcome.new(**)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/HelperInstanceVariable)