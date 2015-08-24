##Patterns: Lint_ConditionPosition
##Issue: {"severity": "Info", "line": 9, "patternId": "Lint_ConditionPosition"}

if x == 5
  #this is good
end

if
  x == 5
  #this is worse than bad
end