##Patterns: Lint_ConditionPosition

if x == 5
  #this is good
end

if
##Info: Lint_ConditionPosition
  x == 5
  #this is worse than bad
end