
Avoid memoizing `find_by` results with `||=`.

It is common to see code that attempts to memoize `find_by` result by `||=`,
but `find_by` may return `nil`, in which case it is not memoized as intended.

NOTE: Respecting the object shapes introduced in Ruby 3.2, instance variables used
for memoization that are initialized at object creation are ignored.

# Examples

```ruby
# bad - exclusively doing memoization
def current_user
  @current_user ||= User.find_by(id: session[:user_id])
end

# good
def current_user
  return @current_user if defined?(@current_user)

  @current_user = User.find_by(id: session[:user_id])
end

# bad - method contains other code
def current_user
  @current_user ||= User.find_by(id: session[:user_id])
  @current_user.do_something
end

# good
def current_user
  if defined?(@current_user)
    @current_user
  else
    @current_user = User.find_by(id: session[:user_id])
  end
  @current_user.do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FindByOrAssignmentMemoization)