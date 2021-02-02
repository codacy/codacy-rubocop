
This cop checks for END blocks.

# Examples

```ruby
# bad
END { puts 'Goodbye!' }

# good
at_exit { puts 'Goodbye!' }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EndBlock)