
Checks for mapping a route with multiple paths, which is deprecated and will be removed in Rails 8.1.

# Examples

```ruby

# bad
get '/users', '/other_path', to: 'users#index'

# good
get '/users', to: 'users#index'
get '/other_path', to: 'users#index'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/MultipleRoutePaths)