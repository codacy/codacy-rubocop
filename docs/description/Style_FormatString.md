
This cop enforces the use of a single string formatting utility.
Valid options include Kernel#format, Kernel#sprintf and String#%.

The detection of String#% cannot be implemented in a reliable
manner for all cases, so only two scenarios are considered -
if the first argument is a string literal and if the second
argument is an array literal.

# Examples

```ruby
# bad
puts sprintf('%10s', 'hoge')
puts '%10s' % 'hoge'

# good
puts format('%10s', 'hoge')# bad
puts format('%10s', 'hoge')
puts '%10s' % 'hoge'

# good
puts sprintf('%10s', 'hoge')# bad
puts format('%10s', 'hoge')
puts sprintf('%10s', 'hoge')

# good
puts '%10s' % 'hoge'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FormatString)