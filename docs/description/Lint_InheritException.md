
This cop looks for error classes inheriting from `Exception`.
It is configurable to suggest using either `StandardError` (default) or
`RuntimeError` instead.

# Examples

```ruby
# bad

class C < Exception; end

C = Class.new(Exception)

# good

class C < StandardError; end

C = Class.new(StandardError)# bad

class C < Exception; end

C = Class.new(Exception)

# good

class C < RuntimeError; end

C = Class.new(RuntimeError)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/InheritException)