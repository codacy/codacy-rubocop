
Checks that predicate method names end with a question mark and
do not start with a forbidden prefix.

A method is determined to be a predicate method if its name starts with
one of the prefixes listed in the `NamePrefix` configuration. The list
defaults to `is_`, `has_`, and `have_` but may be overridden.

Predicate methods must end with a question mark.

When `ForbiddenPrefixes` is also set (as it is by default), predicate
methods which begin with a forbidden prefix are not allowed, even if
they end with a `?`. These methods should be changed to remove the
prefix.

When `UseSorbetSigs` set to true (optional), the cop will only report
offenses if the method has a Sorbet `sig` with a return type of
`T::Boolean`. Dynamic methods are not supported with this configuration.

# Examples

```ruby
# bad
def is_even(value)
end

# When ForbiddenPrefixes: ['is_', 'has_', 'have_'] (default)
# good
def even?(value)
end

# When ForbiddenPrefixes: []
# good
def is_even?(value)
end# bad
def seems_to_be_even(value)
end

# When ForbiddenPrefixes: ['seems_to_be_']
# good
def even?(value)
end

# When ForbiddenPrefixes: []
# good
def seems_to_be_even?(value)
end# Despite starting with the `is_` prefix, this method is allowed
# good
def is_a?(value)
end# good
def is_even?(value)
end# bad
sig { returns(String) }
def is_this_thing_on
  "yes"
end

# good - Sorbet signature is not evaluated
sig { returns(String) }
def is_this_thing_on?
  "yes"
end# bad
sig { returns(T::Boolean) }
def odd(value)
end

# good
sig { returns(T::Boolean) }
def odd?(value)
end# bad
define_method(:is_even) { |value| }

# good
define_method(:even?) { |value| }# bad
def_node_matcher(:is_even) { |value| }

# good
def_node_matcher(:even?) { |value| }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/PredicateName)