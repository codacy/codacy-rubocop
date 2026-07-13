
Checks for `END` blocks. `END` blocks are Perl-style constructs
and `Kernel#at_exit` is the idiomatic Ruby alternative, as it's
explicit and can be used anywhere.

# Examples

```ruby
# bad
END { puts 'Goodbye!' }

# good
at_exit { puts 'Goodbye!' }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EndBlock)