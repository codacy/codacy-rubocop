##Patterns: Lint_ElseLayout
##Issue: {"severity": "Err", "line": 7, "patternId": "Lint_ElseLayout"}

if something
 puts 'Hello World'

else do_this
   do_that
end

#The right way
if somethig
  puts'HelloWorld'
else
  do_that
  do_this
end