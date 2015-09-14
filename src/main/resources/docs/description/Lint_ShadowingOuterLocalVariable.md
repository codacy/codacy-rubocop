Shadowing is when you have two different local variables with the same name. It is said that the variable is defined in
the inner scope "shadows" the one in the outer scope (because t he outer varible is no longer accessible as long as the inner variable scope, even though it would otherwise be in scope)

So in essence you can't access an outer variable with the same name of an inner variable

```
x = 42
5.times { |x| puts x } #You are not using the x above

```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/ShadowingOuterLocalVariable)