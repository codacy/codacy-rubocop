##Patterns: Lint_UselessSetterCall

def something
  x = Something.new
  ##Info: Lint_UselessSetterCall
  x.attr = 5
end