##Patterns: Lint_HandleExceptions


begin
  # an exception occurs here
  ##Warn: Lint_HandleExceptions
rescue SomeError
  # the rescue clause does absolutely nothing
end

do_something rescue nil