
Checks for uses of `Integer#times` that will never yield
(when the integer ``<= 0``) or that will only ever yield once
(`1.times`).

# Examples

```ruby
# bad
-5.times { do_something }
0.times { do_something }
1.times { do_something  }
1.times { |i| do_something(i) }

# good
do_something
do_something(1)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessTimes)