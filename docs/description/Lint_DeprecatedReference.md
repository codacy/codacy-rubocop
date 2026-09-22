
Checks for calls to methods and references to constants that are documented
as deprecated with a YARD `@deprecated` tag.

The check is powered by the project-wide index, so it only runs when
`AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed.
Without the index the cop does nothing.

Only references that can be resolved without type inference are checked:
constants, method calls without an explicit receiver (or with `self`),
which are looked up in the enclosing class or module and its ancestry,
and calls whose receiver is a constant, which are looked up in that
namespace's singleton class. Calls on arbitrary objects are not checked.

References made from a definition that is itself deprecated are allowed,
so deprecated implementations can keep calling each other.

# Examples

```ruby
# Given a deprecated method and constant:
#
#   class Api
#     # @deprecated Use `#new_method` instead.
#     def old_method
#     end
#
#     # @deprecated
#     OLD_TIMEOUT = 10
#   end

# bad
class Client < Api
  def call
    old_method
  end

  def timeout
    OLD_TIMEOUT
  end
end

# good
class Client < Api
  def call
    new_method
  end

  def timeout
    NEW_TIMEOUT
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DeprecatedReference)