
Checks for correct grammar when using ActiveSupport's
core extensions to the numeric classes.

# Examples

```ruby
# bad
3.day.ago
1.months.ago
5.megabyte
1.gigabytes

# good
3.days.ago
1.month.ago
5.megabytes
1.gigabyte
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/PluralizationGrammar)