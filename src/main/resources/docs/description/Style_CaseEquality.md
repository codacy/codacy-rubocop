
This cop checks for uses of the case equality operator(===).

# Examples

```ruby
# bad
Array === something
(1..100) === 7
/something/ === some_string

# good
something.is_a?(Array)
(1..100).include?(7)
some_string =~ /something/
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseEquality)