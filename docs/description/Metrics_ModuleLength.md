
Checks if the length of a module exceeds some maximum value.
Comment lines can optionally be ignored.
The maximum allowed length is configurable.

You can set constructs you want to fold with `CountAsOne`.

Available are: 'array', 'hash', 'heredoc', and 'method_call'.
Each construct will be counted as one line regardless of its actual size.

# Examples

```ruby

module M
  ARRAY = [         # +1
    1,
    2
  ]

  HASH = {          # +1
    key: 'value'
  }

  MSG = <<~HEREDOC  # +1
    Heredoc
    content.
  HEREDOC

  foo(              # +1
    1,
    2
  )
end                 # 4 points
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/ModuleLength)