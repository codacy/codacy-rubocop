
This cop finds regular expressions with dynamic components that are all constants.

Ruby allocates a new Regexp object every time it executes a code containing such
a regular expression. It is more efficient to extract it into a constant
or add an `/o` option to perform `#{}` interpolation only once and reuse that
Regexp object.

# Examples

```ruby

# bad
def tokens(pattern)
  pattern.scan(TOKEN).reject { |token| token.match?(/\A#{SEPARATORS}\Z/) }
end

# good
ALL_SEPARATORS = /\A#{SEPARATORS}\Z/
def tokens(pattern)
  pattern.scan(TOKEN).reject { |token| token.match?(ALL_SEPARATORS) }
end

# good
def tokens(pattern)
  pattern.scan(TOKEN).reject { |token| token.match?(/\A#{SEPARATORS}\Z/o) }
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ConstantRegexp)