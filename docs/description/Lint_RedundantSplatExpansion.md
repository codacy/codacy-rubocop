
This cop checks for unneeded usages of splat expansion

# Examples

```ruby

# bad
a = *[1, 2, 3]
a = *'a'
a = *1
['a', 'b', *%w(c d e), 'f', 'g']

# good
c = [1, 2, 3]
a = *c
a, b = *c
a, *b = *c
a = *1..10
a = ['a']
['a', 'b', 'c', 'd', 'e', 'f', 'g']

# bad
do_something(*['foo', 'bar', 'baz'])

# good
do_something('foo', 'bar', 'baz')

# bad
begin
  foo
rescue *[StandardError, ApplicationError]
  bar
end

# good
begin
  foo
rescue StandardError, ApplicationError
  bar
end

# bad
case foo
when *[1, 2, 3]
  bar
else
  baz
end

# good
case foo
when 1, 2, 3
  bar
else
  baz
end
# good
do_something(*%w[foo bar baz])
# bad
do_something(*%w[foo bar baz])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RedundantSplatExpansion)