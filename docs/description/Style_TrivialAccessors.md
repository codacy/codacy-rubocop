
This cop looks for trivial reader/writer methods, that could
have been created with the attr_* family of functions automatically.

# Examples

```ruby
# bad
def foo
  @foo
end

def bar=(val)
  @bar = val
end

def self.baz
  @baz
end

# good
attr_reader :foo
attr_writer :bar

class << self
  attr_reader :baz
end# good
def name
  @other_name
end# bad
def name
  @other_name
end# good
def foo?
  @foo
end# bad
def foo?
  @foo
end

# good
attr_reader :foo# good
def on_exception(action)
  @on_exception=action
end# bad
def on_exception(action)
  @on_exception=action
end

# good
attr_writer :on_exception# bad
def self.foo
  @foo
end

# good
class << self
  attr_reader :foo
end# good
def self.foo
  @foo
end# good
def allowed_method
  @foo
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/TrivialAccessors)