##Patterns: Lint_UselessSetterCall
##Issue: {"severity": "Info", "line": 6, "patternId": "Lint_UselessSetterCall"}

def something
  x = Something.new
  x.attr = 5
end