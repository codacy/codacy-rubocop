
Checks for `to_json` / `as_json` without whitelisting via `only`.

Either method called on an instance of a `Serializer` class will be
ignored. Associations included via `include` are subject to the same
rules.

See https://gitlab.com/gitlab-org/gitlab-ce/issues/29661

# Examples

```ruby

# bad
render json: @user.to_json
render json: @user.to_json(except: %i[password])
render json: @user.to_json(
  only: %i[username],
  include: [:identities]
)

# acceptable
render json: UserSerializer.new.to_json

# good
render json: @user.to_json(only: %i[name username])
render json: @user.to_json(
  only: %i[username],
  include: { identities: { only: %i[provider] } }
)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/JsonSerialization)