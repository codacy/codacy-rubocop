
This cop checks if each_with_object is called with an immutable
argument. Since the argument is the object that the given block shall
make calls on to build something based on the enumerable that
each_with_object iterates over, an immutable argument makes no sense.
It's definitely a bug.

# Examples

```ruby

# bad

sum = numbers.each_with_object(0) { |e, a| a += e }
# good

num = 0
sum = numbers.each_with_object(num) { |e, a| a += e }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EachWithObjectArgument)