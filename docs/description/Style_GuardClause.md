
Use a guard clause instead of wrapping the code inside a conditional
expression

A condition with an `elsif` or `else` branch is allowed unless
one of `return`, `break`, `next`, `raise`, or `fail` is used
in the body of the conditional expression.

NOTE: Autocorrect works in most cases except with if-else statements
  that contain logical operators such as `foo || raise('exception')`

# Examples

```ruby
# bad
def test
  if something
    work
  end
end

# good
def test
  return unless something

  work
end

# also good
def test
  work if something
end

# bad
if something
  raise 'exception'
else
  ok
end

# good
raise 'exception' if something
ok

# bad
if something
  foo || raise('exception')
else
  ok
end

# good
foo || raise('exception') if something
ok# bad
def test
  if foo?
    work
  end

  if bar?  # <- reports an offense
    work
  end
end# good
def test
  if foo?
    work
  end

  if bar?
    work
  end
end

# bad
def test
  if foo?
    work
  end

  do_something

  if bar?  # <- reports an offense
    work
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/GuardClause)