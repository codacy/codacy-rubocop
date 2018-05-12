
This cop checks that there are no repeated conditions
used in case 'when' expressions.

# Examples

```ruby

# bad

case x
when 'first'
  do_something
when 'first'
  do_something_else
end
# good

case x
when 'first'
  do_something
when 'second'
  do_something_else
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateCaseCondition)