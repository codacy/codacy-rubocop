
Checks for `BEGIN` blocks. They are Perl-style constructs that execute
code before the rest of the file is parsed, making the control flow
harder to follow and reason about.

# Examples

```ruby
# bad
BEGIN { test }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/BeginBlock)