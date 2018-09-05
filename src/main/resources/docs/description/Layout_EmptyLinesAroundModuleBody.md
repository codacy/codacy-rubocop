
This cops checks if empty lines around the bodies of modules match
the configuration.

# Examples

```ruby
# good

module Foo

  def bar
    # ...
  end

end# good

module Foo
  module Bar

    # ...

  end
end# good
module Foo

  def bar; end

end# good

module Foo
  def bar
    # ...
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundModuleBody)