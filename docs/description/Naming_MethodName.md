
Makes sure that all methods use the configured style,
snake_case or camelCase, for their names.

Method names matching patterns are always allowed.

The cop can be configured with `AllowedPatterns` to allow certain regexp patterns:

[source,yaml]
----
Naming/MethodName:
  AllowedPatterns:
    - '\AonSelectionBulkChange\z'
    - '\AonSelectionCleared\z'
----

As well, you can also forbid specific method names or regexp patterns
using `ForbiddenIdentifiers` or `ForbiddenPatterns`:

[source,yaml]
----
Naming/MethodName:
  ForbiddenIdentifiers:
    - 'def'
    - 'super'
  ForbiddenPatterns:
    - '_v1\z'
    - '_gen1\z'
----

# Examples

```ruby
# bad
def fooBar; end

# good
def foo_bar; end# bad
def foo_bar; end

# good
def fooBar; end# bad
def def; end
def super; end# bad
def release_v1; end
def api_gen1; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/MethodName)