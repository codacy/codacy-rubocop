
This cops checks for uses of Proc.new where Kernel#proc
would be more appropriate.

# Examples

```ruby
# bad
p = Proc.new { |n| puts n }

# good
p = proc { |n| puts n }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Proc)