
Enforces the use of a single string formatting utility.
Valid options include `Kernel#format`, `Kernel#sprintf`, and `String#%`.

The detection of `String#%` cannot be implemented in a reliable
manner for all cases, so only two scenarios are considered -
if the first argument is a string literal and if the second
argument is an array literal.

Autocorrection will be applied when using argument is a literal or known built-in conversion
methods such as `to_d`, `to_f`, `to_h`, `to_i`, `to_r`, `to_s`, and `to_sym` on variables,
provided that their return value is not an array. For example, when using `to_s`,
`'%s' % [1, 2, 3].to_s` can be autocorrected without any incompatibility:

[source,ruby]
----
'%s' % [1, 2, 3]        #=> '1'
format('%s', [1, 2, 3]) #=> '[1, 2, 3]'
'%s' % [1, 2, 3].to_s   #=> '[1, 2, 3]'
----

# Examples

```ruby
# bad
puts sprintf('%10s', 'foo')
puts '%10s' % 'foo'

# good
puts format('%10s', 'foo')# bad
puts format('%10s', 'foo')
puts '%10s' % 'foo'

# good
puts sprintf('%10s', 'foo')# bad
puts format('%10s', 'foo')
puts sprintf('%10s', 'foo')

# good
puts '%10s' % 'foo'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FormatString)