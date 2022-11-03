
Enforces or forbids Yoda conditions,
i.e. comparison operations where the order of expression is reversed.
eg. `5 == x`

# Examples

```ruby
# bad
99 == foo
"bar" != foo
42 >= foo
10 < bar

# good
foo == 99
foo == "bar"
foo <= 42
bar > 10
"#{interpolation}" == foo
/#{interpolation}/ == foo# bad
99 == foo
"bar" != foo

# good
99 >= foo
3 < a && a < 5# bad
foo == 99
foo == "bar"
foo <= 42
bar > 10

# good
99 == foo
"bar" != foo
42 >= foo
10 < bar# bad
99 >= foo
3 < a && a < 5

# good
99 == foo
"bar" != foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/YodaCondition)