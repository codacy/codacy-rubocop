##Patterns: Lint_AmbiguousRegexpLiteral

def do_somethig
  puts 'Hello World'
end

##Warn: Lint_AmbiguousRegexpLiteral
do_somethig /pattern/i

do_somethig(/pattern/i)
