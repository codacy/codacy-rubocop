
In Ruby 2.3 or later, use unary plus operator to unfreeze a string
literal instead of `String#dup` and `String.new`.
Unary plus operator is faster than `String#dup`.

# Examples

```ruby
# bad
''.dup
"something".dup
String.new
String.new('')
String.new('something')

# good
+'something'
+''
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/UnfreezeString)