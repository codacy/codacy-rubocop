
Checks for the use of JSON class methods which have potential
security issues.

# Examples

```ruby
# bad
JSON.load("{}")
JSON.restore("{}")

# good
JSON.parse("{}")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Security/JSONLoad)