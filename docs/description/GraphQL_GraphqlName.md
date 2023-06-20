
Checks consistency of graphql_name usage

EnforcedStyle supports two modes:

`only_override` : types and mutations should have graphql_name configured only if it's
 different from the default name

`required` : all types and mutations should have graphql_name configured

# Examples

```ruby
# good

class UserType < BaseType
  graphql_name 'Viewer'
end

# bad

class UserType < BaseType
  graphql_name 'User'
end# good

class UserType < BaseType
  graphql_name 'User'
end

# bad

class UserType < BaseType
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GraphQL/GraphqlName)