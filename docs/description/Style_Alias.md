
Enforces the use of either `#alias` or `#alias_method`
depending on configuration.
It also flags uses of `alias :symbol` rather than `alias bareword`.

However, it will always enforce `method_alias` when used `alias`
in an instance method definition and in a singleton method definition.
If used in a block, always enforce `alias_method`
unless it is an `instance_eval` block.

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