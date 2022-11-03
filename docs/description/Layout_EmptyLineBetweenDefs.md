
Checks whether class/module/method definitions are
separated by one or more empty lines.

`NumberOfEmptyLines` can be an integer (default is 1) or
an array (e.g. [1, 2]) to specify a minimum and maximum
number of empty lines permitted.

`AllowAdjacentOneLineDefs` configures whether adjacent
one-line definitions are considered an offense.

# Examples

```ruby
# checks for empty lines between method definitions.

# bad
def a
end
def b
end
# good
def a
end

def b
end# checks for empty lines between class definitions.

# bad
class A
end
class B
end
def b
end
# good
class A
end

class B
end

def b
end# checks for empty lines between module definitions.

# bad
module A
end
module B
end
def b
end
# good
module A
end

module B
end

def b
end
# good
class ErrorA < BaseError; end
class ErrorB < BaseError; end
class ErrorC < BaseError; end

# good
class ErrorA < BaseError; end

class ErrorB < BaseError; end

class ErrorC < BaseError; end
# bad
class ErrorA < BaseError; end
class ErrorB < BaseError; end
class ErrorC < BaseError; end

# good
class ErrorA < BaseError; end

class ErrorB < BaseError; end

class ErrorC < BaseError; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLineBetweenDefs)