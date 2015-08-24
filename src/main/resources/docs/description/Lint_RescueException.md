##Rescue Exception

Avoid rescuing an Exception class since this will trap signals an call to ``exit``, requiring you to ```kill -9``` the process

**Example:**

```
# bad
begin
  # calls to exit and kill signals will be caught (except kill -9)
  exit
rescue Exception
  puts "you didn't really want to exit, right?"
  # exception handling
end

# good
begin
  # a blind rescue rescues from StandardError, not Exception as many
  # programmers assume.
rescue => e
  # exception handling
end

```