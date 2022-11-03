
Checks for Rails framework classes that are patched directly instead of using Active Support load hooks. Direct
patching forcibly loads the framework referenced, using hooks defers loading until it's actually needed.

# Examples

```ruby

# bad
ActiveRecord::Base.include(MyClass)

# good
ActiveSupport.on_load(:active_record) { include MyClass }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActiveSupportOnLoad)