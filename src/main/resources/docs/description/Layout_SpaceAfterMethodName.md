
Checks for space between a method name and a left parenthesis in defs.

# Examples

```ruby

# bad
def func (x) end
def method= (y) end

# good
def func(x) end
def method=(y) end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAfterMethodName)