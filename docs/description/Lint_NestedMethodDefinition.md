
Checks for nested method definitions.

# Examples

```ruby

# bad

# `bar` definition actually produces methods in the same scope
# as the outer `foo` method. Furthermore, the `bar` method
# will be redefined every time `foo` is invoked.
def foo
  def bar
  end
end

# good

def foo
  bar = -> { puts 'hello' }
  bar.call
end

# good

# `class_eval`, `instance_eval`, `module_eval`, `class_exec`, `instance_exec`, and
# `module_exec` blocks are allowed by default.

def foo
  self.class.class_eval do
    def bar
    end
  end
end

def foo
  self.class.module_exec do
    def bar
    end
  end
end

# good

def foo
  class << self
    def bar
    end
  end
end# bad
def do_something
  has_many :articles do
    def find_or_create_by_name(name)
    end
  end
end# bad
def do_something
  has_many :articles do
    def find_or_create_by_name(name)
    end
  end
end# bad
def foo(obj)
  obj.do_baz do
    def bar
    end
  end
end# good
def foo(obj)
  obj.do_baz do
    def bar
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/NestedMethodDefinition)