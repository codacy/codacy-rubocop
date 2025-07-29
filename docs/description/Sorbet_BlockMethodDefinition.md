
Disallow defining methods in blocks, to prevent running into issues
caused by https://github.com/sorbet/sorbet/issues/3609.

As a workaround, use `define_method` instead.

The one exception is for `Class.new` blocks, as long as the result is
assigned to a constant (i.e. as long as it is not an anonymous class).
Another exception is for ActiveSupport::Concern `class_methods` blocks.

# Examples

```ruby
# bad
yielding_method do
  def bad(args)
    # ...
  end
end

# bad
Class.new do
  def bad(args)
    # ...
  end
end

# good
yielding_method do
  define_method(:good) do |args|
    # ...
  end
end

# good
MyClass = Class.new do
  def good(args)
    # ...
  end
end

# good
module SomeConcern
  extend ActiveSupport::Concern

  class_methods do
    def good(args)
      # ...
    end
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/BlockMethodDefinition)