
Checks for long examples.

A long example is usually more difficult to understand. Consider
extracting out some behavior, e.g. with a `let` block, or a helper
method.

You can set constructs you want to fold with `CountAsOne`.
Available are: 'array', 'hash', 'heredoc', and 'method_call'.
Each construct will be counted as one line regardless of
its actual size.

# Examples

```ruby
# bad
it do
  service = described_class.new
  more_setup
  more_setup
  result = service.call
  expect(result).to be(true)
end

# good
it do
  service = described_class.new
  result = service.call
  expect(result).to be(true)
end
it do
  array = [         # +1
    1,
    2
  ]

  hash = {          # +3
    key: 'value'
  }

  msg = <<~HEREDOC  # +1
    Heredoc
    content.
  HEREDOC

  foo(            # +1
    1,
    2
  )
end               # 6 points
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/ExampleLength)