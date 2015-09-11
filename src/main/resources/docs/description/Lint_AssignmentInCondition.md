##Assignment In Condition

Checks for assignments in the conditions of if/while/until

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
