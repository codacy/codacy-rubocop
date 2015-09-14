You should use ```Fixnum#even?``` instead of ```x % 2 == 0``` since it provides you with some
aditional readability in your code

**Example:**

```
# bad
if x % 2 == 0

# good
if x.even?
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/EvenOdd)