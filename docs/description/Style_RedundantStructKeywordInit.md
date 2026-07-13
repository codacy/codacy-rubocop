
Checks for redundant `keyword_init` option for `Struct.new`.

Since Ruby 3.2, `keyword_init` in `Struct.new` defaults to `nil` behavior.
Therefore, this cop detects and autocorrects redundant `keyword_init: nil`
and `keyword_init: true` in `Struct.new`.

This cop is disabled by default because `keyword_init: true` is not purely
redundant. It changes behavior in the following ways:

- `Struct#keyword_init?` returns `true` instead of `nil`.
- A `Struct` with `keyword_init: true` accepts a `Hash` argument and
  expands it as keyword arguments, whereas without it the `Hash` is
  treated as a positional argument.
- `keyword_init: true` raises an `ArgumentError` for positional arguments,
  enforcing keyword-only initialization.

# Examples

```ruby

# bad
Struct.new(:foo, keyword_init: nil)
Struct.new(:foo, keyword_init: true)

# good
Struct.new(:foo)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantStructKeywordInit)