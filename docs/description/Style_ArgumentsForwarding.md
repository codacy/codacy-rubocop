
In Ruby 2.7, arguments forwarding has been added.

This cop identifies places where `do_something(*args, &block)`
can be replaced by `do_something(...)`.

# Examples

```ruby
# bad
def foo(*args, &block)
  bar(*args, &block)
end

# bad
def foo(*args, **kwargs, &block)
  bar(*args, **kwargs, &block)
end

# good
def foo(...)
  bar(...)
end# good
def foo(*args)
  bar(*args)
end

def foo(**kwargs)
  bar(**kwargs)
end# bad
# The following code can replace the arguments with `...`,
# but it will change the behavior. Because `...` forwards block also.
def foo(*args)
  bar(*args)
end

def foo(**kwargs)
  bar(**kwargs)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ArgumentsForwarding)