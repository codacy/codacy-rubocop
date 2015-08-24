##Patterns: Lint_Loop

##Warn: Lint_Loop
begin
  puts 'Hello World'
end while x < 0

loop do
  puts 'Hello World'
  break unless x < 0
end