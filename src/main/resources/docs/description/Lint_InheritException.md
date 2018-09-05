
This cop looks for error classes inheriting from `Exception`
and its standard library subclasses, excluding subclasses of
`StandardError`. It is configurable to suggest using either
`RuntimeError` (default) or `StandardError` instead.

# Examples

```ruby
# bad

class C < Exception; end

# good

class C < RuntimeError; end# bad

class C < Exception; end

# good

class C < StandardError; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/InheritException)