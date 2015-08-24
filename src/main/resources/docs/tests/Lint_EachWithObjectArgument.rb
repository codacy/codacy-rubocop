##Patterns: Lint_EachWithObjectArgument
##Issue: {"severity": "Err", "line": 4, "patternId": "Lint_EachWithObjectArgument"}

sum = numbers.each_with_object(0) { |e, a| a+=e }