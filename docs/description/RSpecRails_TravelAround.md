
Prefer to travel in `before` rather than `around`.

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