
Enforces the use of consistent method names
`Object#yield_self` or `Object#then`.

# Examples

```ruby

# bad
obj.yield_self { |x| x.do_something }

# good
obj.then { |x| x.do_something }
# bad
obj.then { |x| x.do_something }

# good
obj.yield_self { |x| x.do_something }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ObjectThen)