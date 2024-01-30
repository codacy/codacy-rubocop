
Emulates the following Ruby warning in Ruby 3.3.

[source,ruby]
----
$ ruby -e '0.times { it }'
-e:1: warning: `it` calls without arguments will refer to the first block param in Ruby 3.4;
use it() or self.it
----

`it` calls without arguments will refer to the first block param in Ruby 3.4.
So use `it()` or `self.it` to ensure compatibility.

# Examples

```ruby

# bad
do_something { it }

# good
do_something { it() }
do_something { self.it }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ItWithoutArgumentsInBlock)