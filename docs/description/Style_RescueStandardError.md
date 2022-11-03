
Checks for rescuing `StandardError`. There are two supported
styles `implicit` and `explicit`. This cop will not register an offense
if any error other than `StandardError` is specified.

# Examples

```ruby
# `explicit` will enforce using `rescue StandardError`
# instead of `rescue`.

# bad
begin
  foo
rescue
  bar
end

# good
begin
  foo
rescue StandardError
  bar
end

# good
begin
  foo
rescue OtherError
  bar
end

# good
begin
  foo
rescue StandardError, SecurityError
  bar
end# `implicit` will enforce using `rescue` instead of
# `rescue StandardError`.

# bad
begin
  foo
rescue StandardError
  bar
end

# good
begin
  foo
rescue
  bar
end

# good
begin
  foo
rescue OtherError
  bar
end

# good
begin
  foo
rescue StandardError, SecurityError
  bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RescueStandardError)