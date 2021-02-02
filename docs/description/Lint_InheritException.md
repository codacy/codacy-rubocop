
This cop looks for error classes inheriting from `Exception`
and its standard library subclasses, excluding subclasses of
`StandardError`. It is configurable to suggest using either
`RuntimeError` (default) or `StandardError` instead.

# Examples

```ruby
# bad

class C < Exception; end

C = Class.new(Exception)

# good

class C < RuntimeError; end

C = Class.new(RuntimeError)# bad

class C < Exception; end

C = Class.new(Exception)

# good

class C < StandardError; end

C = Class.new(StandardError)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/InheritException)