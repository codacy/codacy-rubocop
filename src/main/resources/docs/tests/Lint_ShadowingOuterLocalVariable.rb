##Patterns: Lint_ShadowingOuterLocalVariable


x = 42
##Warn: Lint_ShadowingOuterLocalVariable
5.times { |x| puts x }
