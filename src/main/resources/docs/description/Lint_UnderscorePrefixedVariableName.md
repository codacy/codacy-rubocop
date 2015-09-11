##Underscore Prefixed Variable Name

Checks if there is a used variable that is prefixed with '_'

**Example:***


```
#bad
def something(x)
  _used_var = something_else(x)
end

#good
def something(x)
  used_var = something_else(x)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/UnderscorePrefixedVariableName)
