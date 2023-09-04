
Checks if the map method is used in a chain.

Autocorrection is not supported because an appropriate block variable name cannot be determined automatically.

[source,ruby]
----
class X
  def initialize
    @@num = 0
  end

  def foo
    @@num += 1
    self
  end

  def bar
    @@num * 2
  end
end

[X.new, X.new].map(&:foo).map(&:bar) # => [4, 4]
[X.new, X.new].map { |x| x.foo.bar } # => [2, 4]
----

# Examples

```ruby

# bad
array.map(&:foo).map(&:bar)

# good
array.map { |item| item.foo.bar }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/MapMethodChain)