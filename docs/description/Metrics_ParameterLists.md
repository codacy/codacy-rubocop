
Checks for methods with too many parameters.

The maximum number of parameters is configurable.
Keyword arguments can optionally be excluded from the total count,
as they add less complexity than positional or optional parameters.

Any number of arguments for `initialize` method inside a block of
`Struct.new` and `Data.define` like this is always allowed:

[source,ruby]
----
Struct.new(:one, :two, :three, :four, :five, keyword_init: true) do
  def initialize(one:, two:, three:, four:, five:)
  end
end
----

This is because checking the number of arguments of the `initialize` method
does not make sense.

NOTE: Explicit block argument `&block` is not counted to prevent
erroneous change that is avoided by making block argument implicit.

This cop also checks for the maximum number of optional parameters.
This can be configured using the `MaxOptionalParameters` config option.

# Examples

```ruby
# good
def foo(a, b, c = 1)
end# bad
def foo(a, b, c = 1)
end# counts keyword args towards the maximum

# bad (assuming Max is 3)
def foo(a, b, c, d: 1)
end

# good (assuming Max is 3)
def foo(a, b, c: 1)
end# don't count keyword args towards the maximum

# good (assuming Max is 3)
def foo(a, b, c, d: 1)
end# good
def foo(a = 1, b = 2, c = 3)
end# bad
def foo(a = 1, b = 2, c = 3)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Metrics/ParameterLists)