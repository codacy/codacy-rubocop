
Checks for useless method definitions, specifically: empty constructors
and methods just delegating to `super`.

# Examples

```ruby
# bad
def initialize
  super
end

def method
  super
end

# good - with default arguments
def initialize(x = Object.new)
  super
end

# good
def initialize
  super
  initialize_internals
end

def method(*args)
  super(:extra_arg, *args)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UselessMethodDefinition)