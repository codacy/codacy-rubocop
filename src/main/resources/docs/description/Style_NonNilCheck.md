##Non Nil Check

Don't do explicit non-nil checks unless you're dealing with boolean values.

**Example:**

```
# bad
do_something if !something.nil?
do_something if something != nil

# good
do_something if something

# good - dealing with a boolean
def value_set?
  !@some_boolean.nil?
end
```