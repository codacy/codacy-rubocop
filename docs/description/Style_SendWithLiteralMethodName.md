
Detects the use of the `public_send` method with a literal method name argument.
Since the `send` method can be used to call private methods, by default,
only the `public_send` method is detected.

# Examples

```ruby
# bad
obj.public_send(:method_name)
obj.public_send('method_name')

# good
obj.method_name# good
obj.send(:method_name)
obj.send('method_name')
obj.__send__(:method_name)
obj.__send__('method_name')# bad
obj.send(:method_name)
obj.send('method_name')
obj.__send__(:method_name)
obj.__send__('method_name')

# good
obj.method_name
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/SendWithLiteralMethodName)