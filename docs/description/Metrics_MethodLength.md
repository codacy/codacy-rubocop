
This cop checks if the length of a method exceeds some maximum value.
Comment lines can optionally be ignored.
The maximum allowed length is configurable.

You can set literals you want to fold with `CountAsOne`.
Available are: 'array', 'hash', and 'heredoc'. Each literal
will be counted as one line regardless of its actual size.

NOTE: The `ExcludedMethods` configuration is deprecated and only kept
for backwards compatibility. Please use `IgnoredMethods` instead.

# Examples

```ruby

def m
  array = [       # +1
    1,
    2
  ]

  hash = {        # +3
    key: 'value'
  }

  <<~HEREDOC      # +1
    Heredoc
    content.
  HEREDOC
end               # 5 points
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/MethodLength)