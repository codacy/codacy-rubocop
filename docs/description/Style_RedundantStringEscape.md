
Checks for redundant escapes in string literals.

# Examples

```ruby
# bad - no need to escape # without following {/$/@
"\#foo"

# bad - no need to escape single quotes inside double quoted string
"\'foo\'"

# bad - heredocs are also checked for unnecessary escapes
<<~STR
  \#foo \"foo\"
STR

# good
"#foo"

# good
"\#{no_interpolation}"

# good
"'foo'"

# good
"foo\
bar"

# good
<<~STR
  #foo "foo"
STR
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantStringEscape)