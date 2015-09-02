##Guard Clause

Avoid the use of nested conditionals for flow control

Prefer a guard clause when you can assert  invalid data. A guard clause is a conditional statement at the top of a function that bails out as soon as it can.

**Example:**

```
# bad
def compute_thing(thing)
  if thing[:foo]
    update_with_bar(thing)
    if thing[:foo][:bar]
      partial_compute(thing)
    else
      re_compute(thing)
    end
  end
end

# good
def compute_thing(thing)
  return unless thing[:foo]
  update_with_bar(thing[:foo])
  return re_compute(thing) unless thing[:foo][:bar]
  partial_compute(thing)
end
```