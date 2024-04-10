
Checks for self-assignments.

# Examples

```ruby
# bad
foo = foo
foo, bar = foo, bar
Foo = Foo

# good
foo = bar
foo, bar = bar, foo
Foo = Bar
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/SelfAssignment)