##Useless Else Without Rescue

Checks for useless else in begin..end without rescue since it will never run

**Example:**

```
begin
  do_something
else
  handle_errors #This will never run
end

```
