
Checks that the equals signs in parameter default assignments
have or don't have surrounding space depending on configuration.

# Examples

```ruby
# bad
def some_method(arg1=:default, arg2=nil, arg3=[])
  # do something...
end

# good
def some_method(arg1 = :default, arg2 = nil, arg3 = [])
  # do something...
end# bad
def some_method(arg1 = :default, arg2 = nil, arg3 = [])
  # do something...
end

# good
def some_method(arg1=:default, arg2=nil, arg3=[])
  # do something...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAroundEqualsInParameterDefault)