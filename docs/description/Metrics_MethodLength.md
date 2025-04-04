
Checks if the length of a method exceeds some maximum value.
Comment lines can optionally be allowed.
The maximum allowed length is configurable.

You can set constructs you want to fold with `CountAsOne`.

Available are: 'array', 'hash', 'heredoc', and 'method_call'.
Each construct will be counted as one line regardless of its actual size.

NOTE: The `ExcludedMethods` and `IgnoredMethods` configuration is
deprecated and only kept for backwards compatibility.
Please use `AllowedMethods` and `AllowedPatterns` instead.
By default, there are no methods to allowed.

# Examples

```ruby

def m
  array = [       # +1
    1,
    2
  ]

  hash = {        # +1
    key: 'value'
  }

  <<~HEREDOC      # +1
    Heredoc
    content.
  HEREDOC

  foo(            # +1
    1,
    2
  )
end               # 4 points
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/MethodLength)