
This cop enforces the use of consistent method names
from the String class.

# Examples

```ruby
# bad
'name'.intern
'var'.unfavored_method

# good
'name'.to_sym
'var'.preferred_method
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/StringMethods)