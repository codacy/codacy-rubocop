
Checks that predicate methods end with `?` and non-predicate methods do not.

The names of predicate methods (methods that return a boolean value) should end
in a question mark. Methods that don't return a boolean, shouldn't
end in a question mark.

The cop assesses a predicate method as one that returns boolean values. Likewise,
a method that only returns literal values is assessed as non-predicate. Other predicate
method calls are assumed to return boolean values. The cop does not make an assessment
if the return type is unknown (non-predicate method calls, variables, etc.).

NOTE: The `initialize` method and operator methods (`def ==`, etc.) are ignored.

By default, the cop runs in `conservative` mode, which allows a method to be named
with a question mark as long as at least one return value is boolean. In `aggressive`
mode, methods with a question mark will register an offense if any known non-boolean
return values are detected.

The cop also has `AllowedMethods` configuration in order to prevent the cop from
registering an offense from a method name that does not confirm to the naming
guidelines. By default, `call` is allowed. The cop also has `AllowedPatterns`
configuration to allow method names by regular expression.

Although returning a call to another predicate method is treated as a boolean value,
certain method names can be known to not return a boolean, despite ending in a `?`
(for example, `Numeric#nonzero?` returns `self` or `nil`). These methods can be
configured using `NonBooleanPredicates`.

The cop can furthermore be configured to allow all bang methods (method names
ending with `!`), with `AllowBangMethods: true` (default false).

# Examples

```ruby
# bad
def foo
  bar == baz
end

# good
def foo?
  bar == baz
end

# bad
def foo?
  5
end

# good
def foo
  5
end

# bad
def foo
  x == y
end

# good
def foo?
  x == y
end

# bad
def foo
  !x
end

# good
def foo?
  !x
end

# bad - returns the value of another predicate method
def foo
  bar?
end

# good
def foo?
  bar?
end

# good - operator method
def ==(other)
  hash == other.hash
end

# good - at least one return value is boolean
def foo?
  return unless bar?
  true
end

# ok - return type is not known
def foo?
  bar
end

# ok - return type is not known
def foo
  bar?
end# bad - the method returns nil in some cases
def foo?
  return unless bar?
  true
end# bad
def save!
  true
end# good
def save!
  true
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/PredicateMethod)