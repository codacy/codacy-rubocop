
This cops checks if empty lines around the bodies of classes match
the configuration.

# Examples

```ruby
# good

class Foo

  def bar
    # ...
  end

end# good

class Foo
  class Bar

    # ...

  end
end# good
class Foo

  def bar; end

end# good

class Foo

  def bar
    # ...
  end
end# good

class Foo
  def bar
    # ...
  end

end# good

class Foo
  def bar
    # ...
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundClassBody)