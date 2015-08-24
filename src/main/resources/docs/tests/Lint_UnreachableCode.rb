##Patterns: Lint_UnreachableCode

def something
 x = true
 return x
 ##Warn: Lint_UnreachableCode
  if x == false
    puts 'Hello'
  end
end
