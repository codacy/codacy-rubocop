
Checks that `if` and `only` (or `except`) are not used together
as options of `skip_*` action filter.

The `if` option will be ignored when `if` and `only` are used together.
Similarly, the `except` option will be ignored when `if` and `except`
are used together.

# Examples

```ruby
# bad
class MyPageController < ApplicationController
  skip_before_action :login_required,
    only: :show, if: :trusted_origin?
end

# good
class MyPageController < ApplicationController
  skip_before_action :login_required,
    if: -> { trusted_origin? && action_name == "show" }
end# bad
class MyPageController < ApplicationController
  skip_before_action :login_required,
    except: :admin, if: :trusted_origin?
end

# good
class MyPageController < ApplicationController
  skip_before_action :login_required,
    if: -> { trusted_origin? && action_name != "admin" }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/IgnoredSkipActionFilterOption)