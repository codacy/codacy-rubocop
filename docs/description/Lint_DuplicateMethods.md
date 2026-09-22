
Checks for duplicated instance (or singleton) method
definitions.

NOTE: Aliasing a method to itself is allowed, as it indicates that
the developer intends to suppress Ruby's method redefinition warnings.
See https://bugs.ruby-lang.org/issues/13574.

By default the cop can only detect duplicates within a single file.
When `AllCops/UseProjectIndex` is enabled and the `rubydex` gem is installed,
the cop additionally consults the project-wide index and reports methods
whose duplicate definition lives in another file.

NOTE: The project index does not record whether a definition in another
file is wrapped in a conditional, so a platform-specific redefinition in
another file may still be reported. Aliasing the method to itself (see above)
before redefining marks the redefinition as intentional and is respected
across files. With `AllCops/ActiveSupportExtensionsEnabled: true`, Active
Support's redefinition markers (`silence_redefinition_of_method` and
`redefine_method`) are honored the same way.

NOTE: Methods defined with `define_method` are not recorded in the project
index, so a duplicate whose other definition uses `define_method` cannot
be detected across files.

Cross-file duplicates whose other definition lives in a file matching one
of the `AllowedCrossFilePaths` patterns are not reported. This suits files
that redefine application methods but are never loaded together with them,
such as standalone scripts. Patterns are matched with the same glob (or
regexp) semantics as `Exclude`, against the other file's path relative to
the directory of the `.rubocop.yml` that configures the cop; absolute
patterns are matched against the absolute path. Offenses inside such files
themselves are best silenced with an ordinary per-cop `Exclude`.

# Examples

```ruby

# bad
def foo
  1
end

def foo
  2
end

# bad
def foo
  1
end

alias foo bar

# good
def foo
  1
end

def bar
  2
end

# good
def foo
  1
end

alias bar foo

# good
alias foo foo
def foo
  1
end

# good
alias_method :foo, :foo
def foo
  1
end

# bad
class MyClass
  extend Forwardable

  # or with: `def_instance_delegator`, `def_delegators`, `def_instance_delegators`
  def_delegator :delegation_target, :delegated_method_name

  def delegated_method_name
  end
end

# good
class MyClass
  extend Forwardable

  def_delegator :delegation_target, :delegated_method_name

  def non_duplicated_delegated_method_name
  end
end


# good
def foo
  1
end

delegate :foo, to: :bar


# bad
def foo
  1
end

delegate :foo, to: :bar

# good
def foo
  1
end

delegate :baz, to: :bar

# good - delegate with splat arguments is ignored
def foo
  1
end

delegate :foo, **options

# good - delegate inside a condition is ignored
def foo
  1
end

if cond
  delegate :foo, to: :bar
end

# good - Active Support's redefinition markers signal an intentional
# redefinition of a method defined in another file
silence_redefinition_of_method :foo
def foo
  1
end

# Cross-file duplicates whose other definition lives in a file
# matching one of the patterns are not reported.

# good - assuming `AppHelper#format` is also defined in
# `script/backfill.rb`, which is never loaded with this file
class AppHelper
  def format
  end
end

# A project's own `delegate`-shaped macros can be registered so the
# methods they define are recognized (with
# `AllCops/ActiveSupportExtensionsEnabled: true`).

# bad
def foo
  1
end

expose :foo, to: :bar
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateMethods)