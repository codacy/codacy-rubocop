
Check for use of system("/bin/ls #{params[:file]}")

Passing user input to system() without sanitization and parameterization can result in command injection

# Examples

```ruby

# bad
system("/bin/ls #{filename}")

# good (parameters)
system("/bin/ls", filename)
# even better
exec("/bin/ls", shell_escape(filename))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/GitlabSecurity/SystemCommandInjection)