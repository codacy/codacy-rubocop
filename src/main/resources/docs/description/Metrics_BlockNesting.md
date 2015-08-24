##Block Nesting

Checks how many nested blocks are contained within a method, if there are too many this can become a problem to the person reading the code
and it can probably be refactored to a better, cleaner and clearer code.

It can provide even more problems since having many loops can be very slow to process and therefore it can be refactored to faster code

***Example:***

```
def hello
  while x < 10
    while y < 11
      while j < 12
        while m < 13
          #This can probably be refactored
        end
      end
    end
  end
end
```