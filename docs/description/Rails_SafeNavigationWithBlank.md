
Checks to make sure safe navigation isn't used with `blank?` in
a conditional.

# Examples

```ruby
# bad
do_something if foo&.blank?
do_something unless foo&.blank?

# good
do_something if foo.blank?
do_something unless foo.blank?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/SafeNavigationWithBlank)