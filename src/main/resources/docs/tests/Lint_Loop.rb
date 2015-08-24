##Patterns: Lint_Loop

begin
  puts 'Hello World'
##Warn: Lint_Loop
end while x < 0

loop do
  puts 'Hello World'
  break unless x < 0
end