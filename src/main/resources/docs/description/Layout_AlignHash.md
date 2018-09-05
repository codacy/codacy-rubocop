
Check that the keys, separators, and values of a multi-line hash
literal are aligned according to configuration. The configuration
options are:

  - key (left align keys)
  - separator (align hash rockets and colons, right align keys)
  - table (left align keys, hash rockets, and values)

The treatment of hashes passed as the last argument to a method call
can also be configured. The options are:

  - always_inspect
  - always_ignore
  - ignore_implicit (without curly braces)
  - ignore_explicit (with curly braces)

# Examples

```ruby
# bad
{
  :foo => bar,
   :ba => baz
}

# good
{
  :foo => bar,
  :ba => baz
}# bad
{
  :foo => bar,
  :ba => baz
}
{
  :foo => bar,
  :ba  => baz
}

# good
{
  :foo => bar,
   :ba => baz
}# bad
{
  :foo => bar,
   :ba => baz
}

# good
{
  :foo => bar,
  :ba  => baz
}# bad
{
  foo: bar,
   ba: baz
}

# good
{
  foo: bar,
  ba: baz
}# bad
{
  foo: bar,
  ba: baz
}

# good
{
  foo: bar,
   ba: baz
}# bad
{
  foo: bar,
  ba: baz
}

# good
{
  foo: bar,
  ba:  baz
}# Inspect both implicit and explicit hashes.

# bad
do_something(foo: 1,
  bar: 2)

# bad
do_something({foo: 1,
  bar: 2})

# good
do_something(foo: 1,
             bar: 2)

# good
do_something(
  foo: 1,
  bar: 2
)

# good
do_something({foo: 1,
              bar: 2})

# good
do_something({
  foo: 1,
  bar: 2
})# Ignore both implicit and explicit hashes.

# good
do_something(foo: 1,
  bar: 2)

# good
do_something({foo: 1,
  bar: 2})# Ignore only implicit hashes.

# bad
do_something({foo: 1,
  bar: 2})

# good
do_something(foo: 1,
  bar: 2)# Ignore only explicit hashes.

# bad
do_something(foo: 1,
  bar: 2)

# good
do_something({foo: 1,
  bar: 2})
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/AlignHash)