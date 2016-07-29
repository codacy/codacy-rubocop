##Patterns: Lint_ConditionPosition

if x == 5
  #this is good
end

if
  ##Warn: Lint_ConditionPosition
  x == 5
  #this is worse than bad
end
