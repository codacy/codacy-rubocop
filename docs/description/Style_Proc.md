
Checks for uses of `Proc.new` where `Kernel#proc`
would be more appropriate. `proc` is the shorter and
more idiomatic way to create procs in Ruby.

# Examples

```ruby
# bad
p = Proc.new { |n| puts n }

# good
p = proc { |n| puts n }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Proc)