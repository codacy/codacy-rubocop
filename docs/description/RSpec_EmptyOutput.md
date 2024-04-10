
Check that the `output` matcher is not called with an empty string.

# Examples

```ruby
# bad
expect { foo }.to output('').to_stdout
expect { bar }.not_to output('').to_stderr

# good
expect { foo }.not_to output.to_stdout
expect { bar }.to output.to_stderr
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/EmptyOutput)