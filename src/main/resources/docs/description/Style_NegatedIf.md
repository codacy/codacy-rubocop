##Negated if

 Favor unless over if for negative conditions (or control flow ||)

 **Example:**

 ```
# bad
do_something if !some_condition

# bad
do_something if not some_condition

# good
do_something unless some_condition

# another good option
some_condition || do_something
 ```