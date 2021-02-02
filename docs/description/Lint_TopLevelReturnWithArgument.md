
This cop checks for top level return with arguments. If there is a
top-level return statement with an argument, then the argument is
always ignored. This is detected automatically since Ruby 2.7.

# Examples

```ruby

# Detected since Ruby 2.7
return 1 # 1 is always ignored.
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/TopLevelReturnWithArgument)