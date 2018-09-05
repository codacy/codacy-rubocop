
This cop checks for the presence of `when` branches without a body.

# Examples

```ruby

# bad

case foo
when bar then 1
when baz then # nothing
end
# good

case foo
when bar then 1
when baz then 2
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/EmptyWhen)