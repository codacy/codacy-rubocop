
If `AllowOnSelfClass` option is enabled, the cop will ignore violations when the receiver of
the case equality operator is `self.class`. Note intermediate variables are not accepted.

# Examples

```ruby
# bad
(1..100) === 7
/something/ === some_string

# good
something.is_a?(Array)
(1..100).include?(7)
/something/.match?(some_string)# bad
Array === something# good
Array === something# bad
self.class === something# good
self.class === something
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseEquality)