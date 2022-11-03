
Identifies top-level `HashWithIndifferentAccess`.
This has been soft-deprecated since Rails 5.1.

# Examples

```ruby
# bad
HashWithIndifferentAccess.new(foo: 'bar')

# good
ActiveSupport::HashWithIndifferentAccess.new(foo: 'bar')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/TopLevelHashWithIndifferentAccess)