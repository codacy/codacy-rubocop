
Avoid mutating class and module attributes.

They are implemented by class variables, which are not thread-safe.

# Examples

```ruby
# bad
class User
  cattr_accessor :current_user
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/ClassAndModuleAttributes)