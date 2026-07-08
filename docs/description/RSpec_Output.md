
Checks for the use of output calls like puts and print in specs.

# Examples

```ruby
# bad
puts 'A debug message'
pp 'A debug message'
print 'A debug message'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/RSpec/Output)