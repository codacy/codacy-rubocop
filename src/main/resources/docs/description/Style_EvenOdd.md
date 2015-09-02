##Even Odd numbers proper checking

You should use ```Fixnum#even?``` instead of ```x % 2 == 0``` since it provides you with some
aditional readability in your code

**Example:**

```
# bad
if x % 2 == 0

# good
if x.even?
```