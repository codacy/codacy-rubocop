
Do not mix named captures and numbered captures in a `Regexp` literal
because numbered capture is ignored if they're mixed.
Replace numbered captures with non-capturing groupings or
named captures.

# Examples

```ruby
# bad
/(?<foo>FOO)(BAR)/

# good
/(?<foo>FOO)(?<bar>BAR)/

# good
/(?<foo>FOO)(?:BAR)/

# good
/(FOO)(BAR)/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/MixedRegexpCaptureTypes)