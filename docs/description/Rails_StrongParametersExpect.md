
Enforces the use of `ActionController::Parameters#expect` as a method for strong parameter handling.

# Examples

```ruby

# bad
params.require(:user).permit(:name, :age)
params.permit(user: [:name, :age]).require(:user)

# good
params.expect(user: [:name, :age])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/StrongParametersExpect)