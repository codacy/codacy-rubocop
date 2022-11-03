
Checks for classes and metaclasses without a body.
Such empty classes and metaclasses are typically an oversight or we should provide a comment
to be clearer what we're aiming for.

# Examples

```ruby
# bad
class Foo
end

class Bar
  class << self
  end
end

class << obj
end

# good
class Foo
  def do_something
    # ... code
  end
end

class Bar
  class << self
    attr_reader :bar
  end
end

class << obj
  attr_reader :bar
end# bad
class Foo
  # TODO: implement later
end

class Bar
  class << self
    # TODO: implement later
  end
end

class << obj
  # TODO: implement later
end# good
class Foo
  # TODO: implement later
end

class Bar
  class << self
    # TODO: implement later
  end
end

class << obj
  # TODO: implement later
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyClass)