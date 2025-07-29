
Checks for duplicated instance (or singleton) method
definitions.

NOTE: Aliasing a method to itself is allowed, as it indicates that
the developer intends to suppress Ruby's method redefinition warnings.
See https://bugs.ruby-lang.org/issues/13574.

# Examples

```ruby

# bad
def foo
  1
end

def foo
  2
end

# bad
def foo
  1
end

alias foo bar

# good
def foo
  1
end

def bar
  2
end

# good
def foo
  1
end

alias bar foo

# good
alias foo foo
def foo
  1
end

# good
alias_method :foo, :foo
def foo
  1
end
# good
def foo
  1
end

delegate :foo, to: :bar
# bad
def foo
  1
end

delegate :foo, to: :bar

# good
def foo
  1
end

delegate :baz, to: :bar

# good - delegate with splat arguments is ignored
def foo
  1
end

delegate :foo, **options

# good - delegate inside a condition is ignored
def foo
  1
end

if cond
  delegate :foo, to: :bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateMethods)