
Enforces the use of `ActionController::Parameters#expect` as a method for strong parameter handling.

In the following cases, `params[:key]` is treated as a key that is expected to be passed from the HTTP client,
and the cop detects it using the `expect` method.

- Method calls on `params[:key]` without comparison methods, methods that are safe to call
  on `nil` (such as `to_i`, `to_s`, or `is_a?`), key-check methods such as `key?`,
  collection methods such as `keys`, `merge`, or `slice`, or block-style calls such as
  `params[:key].each { ... }` or `params[:key].map(&:to_s)`
- Passing `params[:key]` as an argument to finder methods that raise on missing records
- Strong parameter methods using `require` or `permit`

Other cases are not detected, as they are cases where `params[:key]` may not be passed from the HTTP client.

# Examples

```ruby

# bad
params[:key].do_something

# good
params.expect(:key).do_something

# bad
Model.find(params[:id])

# good
Model.find(params.expect(:id))

# bad
Model.find_by!(key: params[:key])

# good
Model.find_by!(key: params.expect(:key))

# bad
params.require(:user).permit(:name, :age)
params.permit(user: [:name, :age]).require(:user)

# good
params.expect(user: [:name, :age])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/StrongParametersExpect)