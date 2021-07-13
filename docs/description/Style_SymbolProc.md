
Use symbols as procs when possible.

If you prefer a style that allows block for method with arguments,
please set `true` to `AllowMethodsWithArguments`.

# Examples

```ruby
# bad
something.map { |s| s.upcase }
something.map { _1.upcase }

# good
something.map(&:upcase)# bad
something.do_something(foo) { |o| o.bar }

# good
something.do_something(foo, &:bar)# good
something.do_something(foo) { |o| o.bar }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SymbolProc)