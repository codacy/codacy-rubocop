##Patterns: Lint_EachWithObjectArgument

##Warn: Lint_EachWithObjectArgument
sum = numbers.each_with_object(0) { |e, a| a+=e }
