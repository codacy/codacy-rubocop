##Patterns: Lint_SuppressedException


begin
  # an exception occurs here
  ##Warn: Lint_SuppressedException
rescue SomeError
end

do_something rescue nil
