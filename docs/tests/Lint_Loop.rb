##Patterns: Lint_Loop
##Issue: {"severity": "Warn", "line": 6, "patternId": "Lint_Loop"}

begin
  puts 'Hello World'
end while x < 0

loop do
  puts 'Hello World'
  break unless x < 0
end
