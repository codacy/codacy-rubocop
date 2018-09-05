
Checks for uses of if with a negated condition. Only ifs
without else are considered. There are three different styles:

  - both
  - prefix
  - postfix

# Examples

```ruby
# enforces `unless` for `prefix` and `postfix` conditionals

# bad

if !foo
  bar
end

# good

unless foo
  bar
end

# bad

bar if !foo

# good

bar unless foo# enforces `unless` for just `prefix` conditionals

# bad

if !foo
  bar
end

# good

unless foo
  bar
end

# good

bar if !foo# enforces `unless` for just `postfix` conditionals

# bad

bar if !foo

# good

bar unless foo

# good

if !foo
  bar
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/NegatedIf)