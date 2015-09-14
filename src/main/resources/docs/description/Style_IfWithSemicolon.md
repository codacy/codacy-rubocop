 Do not use if x; .... Use the ternary operator instead.

 **Example:**

 ```
# bad
result = if some_condition; something else something_else end

# good
result = some_condition ? something : something_else
 ```


[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IfWithSemicolon)