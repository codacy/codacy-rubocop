Checks for assignments in the conditions of if/while/until.

It is a common error to mistakenly use a `=` instead of `==` in a condition.
If it's intentional, and you really want to do an assignment in a condition, please surround it with braces, while having the AllowSafeAssignment parameter set as `true`.
If the AllowSafeAssignment parameter is set to false, you can't do assignments inside conditions.

```
#You shouldn't do this
if v = array.grep(/foo/)
	do_something
end

#This is a good practice
v = array.grep(/foo/)
if v
	do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/AssignmentInCondition)