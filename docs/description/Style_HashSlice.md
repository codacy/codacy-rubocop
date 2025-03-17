
Checks for usages of `Hash#reject`, `Hash#select`, and `Hash#filter` methods
that can be replaced with `Hash#slice` method.

This cop should only be enabled on Ruby version 2.5 or higher.
(`Hash#slice` was added in Ruby 2.5.)

For safe detection, it is limited to commonly used string and symbol comparisons
when using `==` or `!=`.

This cop doesn't check for `Hash#delete_if` and `Hash#keep_if` because they
modify the receiver.

# Examples

```ruby

# bad
{foo: 1, bar: 2, baz: 3}.select {|k, v| k == :bar }
{foo: 1, bar: 2, baz: 3}.reject {|k, v| k != :bar }
{foo: 1, bar: 2, baz: 3}.filter {|k, v| k == :bar }
{foo: 1, bar: 2, baz: 3}.select {|k, v| k.eql?(:bar) }

# bad
{foo: 1, bar: 2, baz: 3}.select {|k, v| %i[bar].include?(k) }
{foo: 1, bar: 2, baz: 3}.reject {|k, v| !%i[bar].include?(k) }
{foo: 1, bar: 2, baz: 3}.filter {|k, v| %i[bar].include?(k) }

# good
{foo: 1, bar: 2, baz: 3}.slice(:bar)
# good
{foo: 1, bar: 2, baz: 3}.select {|k, v| !%i[bar].exclude?(k) }
{foo: 1, bar: 2, baz: 3}.reject {|k, v| %i[bar].exclude?(k) }

# good
{foo: 1, bar: 2, baz: 3}.select {|k, v| k.in?(%i[bar]) }
{foo: 1, bar: 2, baz: 3}.reject {|k, v| !k.in?(%i[bar]) }
# bad
{foo: 1, bar: 2, baz: 3}.select {|k, v| !%i[bar].exclude?(k) }
{foo: 1, bar: 2, baz: 3}.reject {|k, v| %i[bar].exclude?(k) }

# bad
{foo: 1, bar: 2, baz: 3}.select {|k, v| k.in?(%i[bar]) }
{foo: 1, bar: 2, baz: 3}.reject {|k, v| !k.in?(%i[bar]) }

# good
{foo: 1, bar: 2, baz: 3}.slice(:bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/HashSlice)