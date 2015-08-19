##Patterns: Lint_AssignmentInCondition

#Info: Lint_AssignmentInCondition
if v = array.grep(/foo/)
  puts 'hello world'
end

#Good way
v = array.grep(/foo/)
if v
  puts 'Hello world'
end
