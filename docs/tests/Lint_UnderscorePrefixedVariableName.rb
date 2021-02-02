##Patterns: Lint_UnderscorePrefixedVariableName

def something
  ##Warn: Lint_UnderscorePrefixedVariableName
  _used_var = 5
  _used_var = _used_var + 1
end
