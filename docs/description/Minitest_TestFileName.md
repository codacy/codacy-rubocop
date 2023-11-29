
Checks if test file names start with `test_` or end with `_test.rb`.
Files which define classes having names ending with `Test` are checked.
Not following this convention may result in tests not being run.

# Examples

```ruby
# bad
my_class.rb

# good
my_class_test.rb
test_my_class.rb
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Minitest/TestFileName)