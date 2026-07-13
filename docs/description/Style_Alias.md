
Enforces the use of either `#alias` or `#alias_method`
depending on configuration. Consistent use of one or the
other prevents confusion about their different semantics
(e.g., `alias` is resolved at parse time, while `alias_method`
is resolved at runtime).
It also flags uses of `alias :symbol` rather than `alias bareword`.

However, it will always enforce `alias_method` when `alias` is used
in an instance method definition and in a singleton method definition.
If used in a block, always enforce `alias_method`
unless it is an `instance_eval` block.

# Examples

```ruby
# bad
alias_method :bar, :foo
alias :bar :foo

# good
alias bar foo

# bad
alias :bar :foo
alias bar foo

# good
alias_method :bar, :foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Alias)