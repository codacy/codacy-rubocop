
Checks for private instance methods that are not referenced anywhere
in the project.

The check is powered by the project-wide index, so it only runs when
`AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed.
Without the index the cop does nothing.

A method counts as referenced when a call with its name appears anywhere
in the indexed project (regardless of the receiver), when it is the source
of an `alias`, or when its name appears in the same file as a symbol or
inside a string literal (covering `send(:name)` and declarative DSLs like
`before_action :name`). An interpolated symbol or string with a literal
prefix (e.g. `send(:"format_#{type}")`) counts as a reference to every
method whose name starts with that prefix; fully dynamic names cannot
be detected. Methods defined in classes or modules with descendants are
not checked, since they may be invoked through `super` or inherited
dispatch.

Methods whose names are composed by a framework (e.g. Rails
`attribute_method_suffix` generating `attribute?` methods) can be
excluded from the check with `AllowedNames` (exact names) or
`AllowedPatterns` (regular expressions).

The cop is disabled by default because symbol-based references from
*other* files (e.g. a Rails callback declared in a concern) cannot be
detected and would be reported as false positives. It is best suited
for occasional dead-code sweeps rather than permanent enforcement.

# Examples

```ruby
# bad - `helper` is never referenced anywhere in the project
class Service
  def call
    do_something
  end

  private

  def helper
  end
end

# good
class Service
  def call
    do_something(helper)
  end

  private

  def helper
  end
end

# good - the name is explicitly allowed
class Contact
  private

  def attribute?
  end
end

# good - the name matches an allowed pattern
class Service
  private

  def before_save_hook
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnusedPrivateMethod)