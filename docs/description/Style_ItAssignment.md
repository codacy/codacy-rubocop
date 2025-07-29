
Checks for local variables and method parameters named `it`,
where `it` can refer to the first anonymous parameter as of Ruby 3.4.
Use a meaningful variable name instead.

NOTE: Although Ruby allows reassigning `it` in these cases, it could
cause confusion if `it` is used as a block parameter elsewhere.

# Examples

```ruby
# bad
it = 5

# good
var = 5

# bad
def foo(it)
end

# good
def foo(arg)
end

# bad
def foo(it = 5)
end

# good
def foo(arg = 5)
end

# bad
def foo(*it)
end

# good
def foo(*args)
end

# bad
def foo(it:)
end

# good
def foo(arg:)
end

# bad
def foo(it: 5)
end

# good
def foo(arg: 5)
end

# bad
def foo(**it)
end

# good
def foo(**kwargs)
end

# bad
def foo(&it)
end

# good
def foo(&block)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ItAssignment)