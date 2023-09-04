
In Ruby 2.7, arguments forwarding has been added.

This cop identifies places where `do_something(*args, &block)`
can be replaced by `do_something(...)`.

In Ruby 3.2, anonymous args/kwargs forwarding has been added.

This cop also identifies places where `use_args(*args)`/`use_kwargs(**kwargs)` can be
replaced by `use_args(*)`/`use_kwargs(**)`; if desired, this functionality can be disabled
by setting UseAnonymousForwarding: false.

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
end# bad
def foo(*args, **kwargs)
  args_only(*args)
  kwargs_only(**kwargs)
end

# good
def foo(*, **)
  args_only(*)
  kwargs_only(**)
end# good
def foo(*args, **kwargs)
  args_only(*args)
  kwargs_only(**kwargs)
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