##Patterns: Lint_UnreachableCode
##Issue: {"severity": "Warn", "line": 7, "patternId": "Lint_UnreachableCode"}

def something
 x = true
 return x
  if x == false
    puts 'Hello'
  end
end
