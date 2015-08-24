##Patterns: Lint_RescueException

begin
  exit

    ##Warn: Lint_RescueException
rescue Exception
  puts 'This is bad'
end