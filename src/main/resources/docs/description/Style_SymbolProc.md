
Use symbols as procs when possible.

# Examples

```ruby
# bad
something.map { |s| s.upcase }

# good
something.map(&:upcase)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SymbolProc)