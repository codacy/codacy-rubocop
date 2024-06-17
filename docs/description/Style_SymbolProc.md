
Use symbols as procs when possible.

If you prefer a style that allows block for method with arguments,
please set `true` to `AllowMethodsWithArguments`.
`define_method?` methods are allowed by default.
These are customizable with `AllowedMethods` option.

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
something.do_something(foo) { |o| o.bar }# bad
something.do_something do |s| # some comment
  # some comment
  s.upcase # some comment
  # some comment
end# good  - if there are comment in either position
something.do_something do |s| # some comment
  # some comment
  s.upcase # some comment
  # some comment
end# good
define_method(:foo) { |foo| foo.bar }# bad
something.map { |s| s.upcase }# good
something.map { |s| s.upcase }# bad
->(x) { x.foo }
proc { |x| x.foo }
Proc.new { |x| x.foo }

# good
lambda(&:foo)
proc(&:foo)
Proc.new(&:foo)# good
->(x) { x.foo }
proc { |x| x.foo }
Proc.new { |x| x.foo }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SymbolProc)