
Checks for the use of `public_send`, `send`, and `__send__` methods.

If passed untrusted input these methods can be used to execute arbitrary
methods on behalf of an attacker.

# Examples

```ruby

# bad
myobj.public_send("#{params[:foo]}")

# good
case params[:foo].to_s
when 'choice1'
  items.choice1
when 'choice2'
  items.choice2
when 'choice3'
  items.choice3
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/PublicSend)