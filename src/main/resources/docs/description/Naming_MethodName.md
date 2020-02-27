
This cop makes sure that all methods use the configured style,
snake_case or camelCase, for their names.

This cop has `IgnoredPatterns` configuration option.

  Naming/MethodName:
    IgnoredPatterns:
      - '\A\s*onSelectionBulkChange\s*'
      - '\A\s*onSelectionCleared\s*'

Method names matching patterns are always allowed.

# Examples

```ruby
# bad
def fooBar; end

# good
def foo_bar; end# bad
def foo_bar; end

# good
def fooBar; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/MethodName)