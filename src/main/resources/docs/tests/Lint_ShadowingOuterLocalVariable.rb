##Patterns: Lint_ShadowingOuterLocalVariable


x = 42
##Err: Lint_ShadowingOuterLocalVariable
5.times { |x| puts x }