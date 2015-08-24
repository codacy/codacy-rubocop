##Patterns: Lint_AmbiguousRegexpLiteral
##Issue: {"severity": "Warn", "line": 8, "patternId": "Lint_AmbiguousRegexpLiteral"}

def do_somethig
  puts 'Hello World'
end

do_somethig /pattern/i

do_somethig(/pattern/i)