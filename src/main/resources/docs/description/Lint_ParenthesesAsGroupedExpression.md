##Parentheses As Grouped Expression

Checks for spaces between the name of a called method and a left parenthesis
To check if this rule applies always run Ruby with -w flag and it will always warn you of this problem

```
#Bad
f (3 + 1)

#Good
f(3 + 1)
```