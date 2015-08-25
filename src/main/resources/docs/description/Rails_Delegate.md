##Delegate

Use the delegate method instead of a method to delegate it adds readability to your code

**Example:**

```
#bad
def bar
  foo.bar
end

#good
delegate :bar, to: :foo

```