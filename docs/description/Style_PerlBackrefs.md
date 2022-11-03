
Looks for uses of Perl-style regexp match
backreferences and their English versions like
$1, $2, $&, &+, $MATCH, $PREMATCH, etc.

# Examples

```ruby
# bad
puts $1

# good
puts Regexp.last_match(1)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/PerlBackrefs)