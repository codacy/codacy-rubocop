
Avoid lazily initializing synchronization primitives with `||=`.

The check-then-set performed by `||=` is not atomic, so concurrent threads
can observe an uninitialized primitive or create more than one instance.
Eagerly assign the primitive (for example in `initialize`) or use a constant.

# Examples

```ruby
# bad
def mutex
  @mutex ||= Mutex.new
end

# bad
def mutex = @mutex ||= Mutex.new

# good
def initialize
  @mutex = Mutex.new
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/ThreadSafety/LazySynchronizationPrimitive)