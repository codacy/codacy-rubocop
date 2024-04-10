
Enforces the consistent use of action filter methods.

The cop is configurable and can enforce the use of the older
something_filter methods or the newer something_action methods.

# Examples

```ruby
# bad
after_filter :do_stuff
append_around_filter :do_stuff
skip_after_filter :do_stuff

# good
after_action :do_stuff
append_around_action :do_stuff
skip_after_action :do_stuff# bad
after_action :do_stuff
append_around_action :do_stuff
skip_after_action :do_stuff

# good
after_filter :do_stuff
append_around_filter :do_stuff
skip_after_filter :do_stuff
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActionFilter)