
Prefer to travel in `before` rather than `around`.

# Examples

```ruby
# bad
around do |example|
  freeze_time do
    example.run
  end
end

# good
before { freeze_time }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Rails/TravelAround)