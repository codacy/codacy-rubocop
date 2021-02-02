
This cop checks for the use of the send method.

# Examples

```ruby
# bad
Foo.send(:bar)
quuz.send(:fred)

# good
Foo.__send__(:bar)
quuz.public_send(:fred)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Send)