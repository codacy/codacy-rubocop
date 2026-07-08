
Checks for constant reassignments.

Emulates Ruby's runtime warning "already initialized constant X"
when a constant is reassigned in the same file and namespace.

The cop tracks constants defined via `NAME = value` syntax as well as
class/module keyword definitions. It detects reassignment when a constant
is first defined one way and then redefined using the `NAME = value` syntax.

The cop cannot catch all offenses, like, for example, when using metaprogramming
(`Module#const_set`).

By default the cop also cannot detect reassignment across files.
When `AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed,
the cop additionally consults the project-wide index and reports reassignments
whose previous definition lives in another file.

The cop only takes into account constants assigned in a "simple" way: directly
inside class/module definition, or within another constant. Other type of assignments
(e.g., inside a conditional) are disregarded.

The cop also tracks constant removal using `Module#remove_const` with symbol
or string argument.

# Examples

```ruby
# bad
X = :foo
X = :bar

# bad
class A
  X = :foo
  X = :bar
end

# bad
module A
  X = :foo
  X = :bar
end

# bad
class FooError < StandardError; end
FooError = Class.new(RuntimeError)

# bad
module M; end
M = 1

# good - keep only one assignment
X = :bar

class A
  X = :bar
end

module A
  X = :bar
end

# good - use OR assignment
X = :foo
X ||= :bar

# good - use conditional assignment
X = :foo
X = :bar unless defined?(X)

# good - remove the assigned constant first
class A
  X = :foo
  remove_const :X
  X = :bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ConstantReassignment)