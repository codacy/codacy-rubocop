##Patterns: Lint_RescueException
##Issue: {"severity": "Warn", "line": 7, "patternId": "Lint_RescueException"}

begin
  exit

rescue Exception
  puts 'This is bad'
end
