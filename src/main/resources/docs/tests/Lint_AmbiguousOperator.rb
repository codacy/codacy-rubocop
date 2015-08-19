##Patterns: Lint_AmbiguousOperator

array = [1,2,3]

def do_something
  puts 'Hello World'
end

##Warn: Lint_AmbiguousOperator
do_something *array

do_something(*array)
