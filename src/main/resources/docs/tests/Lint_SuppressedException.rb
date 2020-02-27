##Patterns: Lint_SuppressedException


begin
  # an exception occurs here
  ##Warn: Lint_SuppressedException
rescue SomeError
  # the rescue clause does absolutely nothing
end

do_something rescue nil
