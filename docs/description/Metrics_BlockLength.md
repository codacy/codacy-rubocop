
Checks if the length of a block exceeds some maximum value.
Comment lines can optionally be ignored.
The maximum allowed length is configurable.
The cop can be configured to ignore blocks passed to certain methods.

You can set constructs you want to fold with `CountAsOne`.

Available are: 'array', 'hash', 'heredoc', and 'method_call'.
Each construct will be counted as one line regardless of its actual size.

NOTE: This cop does not apply for `Struct` definitions.

NOTE: The `ExcludedMethods` configuration is deprecated and only kept
for backwards compatibility. Please use `AllowedMethods` and `AllowedPatterns`
instead. By default, there are no methods to allowed.

# Examples

```ruby

something do
  array = [         # +1
    1,
    2
  ]

  hash = {          # +1
    key: 'value'
  }

  msg = <<~HEREDOC  # +1
    Heredoc
    content.
  HEREDOC

  foo(              # +1
    1,
    2
  )
end                 # 4 points
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/BlockLength)