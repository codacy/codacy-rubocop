
Checks for empty before and after hooks.

# Examples

```ruby
# bad
before {}
after do; end
before(:all) do
end
after(:all) { }

# good
before { create_users }
after do
  cleanup_users
end
before(:all) do
  create_feed
end
after(:all) { cleanup_feed }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyHook)