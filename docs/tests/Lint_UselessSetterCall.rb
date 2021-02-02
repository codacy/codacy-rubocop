##Patterns: Lint_UselessSetterCall

def something
  x = Something.new
  ##Warn: Lint_UselessSetterCall
  x.attr = 5
end
