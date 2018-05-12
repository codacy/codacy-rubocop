
This cop checks for regexp literals used as `match-current-line`.
If a regexp literal is in condition, the regexp matches `$_` implicitly.

# Examples

```ruby
# bad
if /foo/
  do_something
end

# good
if /foo/ =~ $_
  do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RegexpAsCondition)