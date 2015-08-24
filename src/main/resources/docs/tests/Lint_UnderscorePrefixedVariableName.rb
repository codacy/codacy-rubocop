##Patterns: Lint_UnderscorePrefixedVariableName
##Issue: {"severity": "Info", "line": 5, "patternId": "Lint_UnderscorePrefixedVariableName"}

def something
  _used_var = 5
  _used_var = _used_var + 1
end