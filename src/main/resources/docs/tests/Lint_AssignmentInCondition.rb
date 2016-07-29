##Patterns: Lint_AssignmentInCondition

##Warn: Lint_AssignmentInCondition
if v = array.grep(/foo/)
  puts 'hello world'
end

v = array.grep(/foo/)
if v
  puts 'Hello world'
end
