##Else Layout

Checks for odd else block layout one good example is when you have an expression on the same line as the else keyword

```
#Like this

if something
  do_this
else do_that
  and_that
end

#Instead you should have this

if something
  do_this
else
  do_that
  and_that
end
```