
Checks for redundant argument forwarding when calling super with arguments identical to
the method definition.

Using zero arity `super` within a `define_method` block results in `RuntimeError`:

[source,ruby]
----
def m
  define_method(:foo) { super() } # => OK
end

def m
  define_method(:foo) { super }   # => RuntimeError
end
----

Furthermore, any arguments accompanied by a block may potentially be delegating to
`define_method`, therefore, `super` used within these blocks will be allowed.
This approach might result in false negatives, yet ensuring safe detection takes precedence.

# Examples

```ruby
# bad
def method(*args, **kwargs)
  super(*args, **kwargs)
end

# good - implicitly passing all arguments
def method(*args, **kwargs)
  super
end

# good - forwarding a subset of the arguments
def method(*args, **kwargs)
  super(*args)
end

# good - forwarding no arguments
def method(*args, **kwargs)
  super()
end

# good - assigning to the block variable before calling super
def method(&block)
  # Assigning to the block variable would pass the old value to super,
  # under this circumstance the block must be referenced explicitly.
  block ||= proc { 'fallback behavior' }
  super(&block)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SuperArguments)