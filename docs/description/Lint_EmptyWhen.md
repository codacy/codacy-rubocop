
Checks for the presence of `when` branches without a body.

# Examples

```ruby

# bad
case foo
when bar
  do_something
when baz
end

# good
case condition
when foo
  do_something
when bar
  nil
end
# good
case condition
when foo
  do_something
when bar
  # noop
end
# bad
case condition
when foo
  do_something
when bar
  # do nothing
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyWhen)