
Check for use of where("name = '#{params[:name]}'")

Passing user input to where() without parameterization can result in SQL Injection

# Examples

```ruby

# bad
u = User.where("name = '#{params[:name]}'")

# good (parameters)
u = User.where("name = ? AND id = ?", params[:name], params[:id])
u = User.where(name: params[:name], id: params[:id])
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/SqlInjection)