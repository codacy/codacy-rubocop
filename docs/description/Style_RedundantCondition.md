
Checks for unnecessary conditional expressions.

NOTE: Since the intention of the comment cannot be automatically determined,
autocorrection is not applied when a comment is used, as shown below:

[source,ruby]
-----
if b
  # Important note.
  b
else
  c
end
-----

# Examples

```ruby
# bad
a = b ? b : c

# good
a = b || c

# bad
if b
  b
else
  c
end

# good
b || c

# good
if b
  b
elsif cond
  c
end

# bad
a.nil? ? true : a

# good
a.nil? || a

# bad
if a.nil?
  true
else
  a
end

# good
a.nil? || a# good
num.nonzero? ? true : false
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantCondition)