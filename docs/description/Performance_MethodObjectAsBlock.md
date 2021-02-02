
This cop identifies places where methods are converted to blocks, with the
use of `&method`, and passed as arguments to method calls.
It is faster to replace those with explicit blocks, calling those methods inside.

# Examples

```ruby
# bad
array.map(&method(:do_something))
[1, 2, 3].each(&out.method(:puts))

# good
array.map { |x| do_something(x) }
[1, 2, 3].each { |x| out.puts(x) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/MethodObjectAsBlock)