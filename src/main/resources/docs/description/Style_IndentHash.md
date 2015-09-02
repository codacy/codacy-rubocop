##Hash Indentation

Hash literals shall have their first element indented one step (2 spaces) more than the start of the line where the opening bracket is.

**Example:**

```
# bad - single indent
menu_item = {one: 1, two: 2,
  three: 3, four: 4}

# good
menu_item = {
  one: 1, two: 2,
  three: 3, four: 4
}

# good
menu_item =
  {one: 1, two: 2,
   three: 3, four: 4}
```