
Checks method call operators to not have spaces around them.

# Examples

```ruby
# bad
foo. bar
foo .bar
foo . bar
foo. bar .buzz
foo
  . bar
  . buzz
foo&. bar
foo &.bar
foo &. bar
foo &. bar&. buzz
RuboCop:: Cop
RuboCop:: Cop:: Cop
:: RuboCop::Cop

# good
foo.bar
foo.bar.buzz
foo
  .bar
  .buzz
foo&.bar
foo&.bar&.buzz
RuboCop::Cop
RuboCop::Cop::Cop
::RuboCop::Cop
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAroundMethodCallOperator)