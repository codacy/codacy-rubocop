##Patterns: Lint_AmbiguousOperator
##Issue: {"severity": "Warn", "line": 10, "patternId": "Lint_AmbiguousOperator"}

array = [1,2,3]

def do_something
  puts 'Hello World'
end

do_something *array

do_something(*array)
