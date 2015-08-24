##Patterns: Lint_ElseLayout

if something
 puts 'Hello World'

  ##Err: Lint_ElseLayout
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