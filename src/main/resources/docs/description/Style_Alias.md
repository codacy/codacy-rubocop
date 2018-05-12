
This cop enforces the use of either `#alias` or `#alias_method`
depending on configuration.
It also flags uses of `alias :symbol` rather than `alias bareword`.

# Examples

```ruby
# bad
alias_method :bar, :foo
alias :bar :foo

# good
alias bar foo# bad
alias :bar :foo
alias bar foo

# good
alias_method :bar, :foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Alias)