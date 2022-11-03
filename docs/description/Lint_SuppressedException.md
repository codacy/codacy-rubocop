
Checks for `rescue` blocks with no body.

# Examples

```ruby

# bad
def some_method
  do_something
rescue
end

# bad
begin
  do_something
rescue
end

# good
def some_method
  do_something
rescue
  handle_exception
end

# good
begin
  do_something
rescue
  handle_exception
end
# good
def some_method
  do_something
rescue
  # do nothing
end

# good
begin
  do_something
rescue
  # do nothing
end
# bad
def some_method
  do_something
rescue
  # do nothing
end

# bad
begin
  do_something
rescue
  # do nothing
end
# good
def some_method
  do_something
rescue
  nil
end

# good
begin
  do_something
rescue
  # do nothing
end

# good
do_something rescue nil
# bad
def some_method
  do_something
rescue
  nil
end

# bad
begin
  do_something
rescue
  nil
end

# bad
do_something rescue nil
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/SuppressedException)