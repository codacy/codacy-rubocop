
This cop checks to make sure safe navigation isn't used with `blank?` in
a conditional.

While the safe navigation operator is generally a good idea, when
checking `foo&.blank?` in a conditional, `foo` being `nil` will actually
do the opposite of what the author intends.

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