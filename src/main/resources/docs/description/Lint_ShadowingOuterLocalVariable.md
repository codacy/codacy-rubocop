
This cop looks for use of the same name as outer local variables
for block arguments or block local variables.
This is a mimic of the warning
"shadowing outer local variable - foo" from `ruby -cw`.

# Examples

```ruby

# bad

def some_method
  foo = 1

  2.times do |foo| # shadowing outer `foo`
    do_something(foo)
  end
end
# good

def some_method
  foo = 1

  2.times do |bar|
    do_something(bar)
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ShadowingOuterLocalVariable)