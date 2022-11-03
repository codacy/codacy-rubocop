
Using `flash` assignment before `render` in Rails controllers will persist the message for too long.
Check https://guides.rubyonrails.org/action_controller_overview.html#flash-now

# Examples

```ruby

# bad
class HomeController < ApplicationController
  def create
    flash[:alert] = "msg"
    render :index
  end
end

# good
class HomeController < ApplicationController
  def create
    flash.now[:alert] = "msg"
    render :index
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActionControllerFlashBeforeRender)