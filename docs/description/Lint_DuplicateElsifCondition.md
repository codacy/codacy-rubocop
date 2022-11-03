
Checks that there are no repeated conditions used in if 'elsif'.

# Examples

```ruby
# bad
if x == 1
  do_something
elsif x == 1
  do_something_else
end

# good
if x == 1
  do_something
elsif x == 2
  do_something_else
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateElsifCondition)