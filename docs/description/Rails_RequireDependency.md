
Checks for the usage of `require_dependency`.

`require_dependency` is an obsolete method for Rails applications running in Zeitwerk mode.
In Zeitwerk mode, the semantics should match Ruby's and no need to be defensive with load order,
just refer to classes and modules normally.
If the constant name is dynamic, camelize if needed, and constantize.

Applications running in Zeitwerk mode should not use `require_dependency`.

NOTE: This cop is disabled by default. Please enable it if you are using Zeitwerk mode.

# Examples

```ruby
# bad
require_dependency 'some_lib'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RequireDependency)