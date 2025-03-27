
Check for use of redirect_to(params.update())

Passing user params to the redirect_to method provides an open redirect

# Examples

```ruby

# bad
redirect_to(params.update(action:'main'))

# good
redirect_to(whitelist(params))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/RedirectToParamsUpdate)