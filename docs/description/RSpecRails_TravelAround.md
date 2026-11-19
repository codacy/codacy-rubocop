
Checks for time travel helpers in `around` hooks.

In Rails example groups, `freeze_time` in a `before` hook does not need
a block: Rails' `after_teardown` calls `travel_back` after each example.
This also allows an example to use block-form time travel, which Rails
does not allow inside another time travel block.
See https://api.rubyonrails.org/classes/ActiveSupport/Testing/TimeHelpers.html

# Examples

```ruby
# bad
around do |example|
  freeze_time do
    example.run
  end
end

# bad
around do |example|
  freeze_time(&example)
end

# good
before { freeze_time }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpecRails/TravelAround)