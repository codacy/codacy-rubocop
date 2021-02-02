
This cop checks for redundant escapes inside Regexp literals.

# Examples

```ruby
# bad
%r{foo\/bar}

# good
%r{foo/bar}

# good
/foo\/bar/

# good
%r/foo\/bar/

# good
%r!foo\!bar!

# bad
/a\-b/

# good
/a-b/

# bad
/[\+\-]\d/

# good
/[+\-]\d/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantRegexpEscape)