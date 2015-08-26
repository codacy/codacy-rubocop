##Character Literal

Don't use character literal syntax ?x. Since Ruby 1.9 it's basically redundant - ?x would interpreted
as 'x' (a string with a single character in it)

**Example:**

```
# bad
char = ?c

# good
char = 'c'
```