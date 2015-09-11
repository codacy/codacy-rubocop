##Hash Indentation

Hash literals shall have their first element indented one step (2 spaces) more than the start of the line where the opening bracket is.

The value `special_inside_parentheses` means that hash literals with braces
that have their opening brace on the same line as a surrounding opening
round parenthesis, shall have their first key indented relative to the
first position inside the parenthesis.
The value `consistent` means that the indentation of the first key shall
always be relative to the first position of the line where the opening
brace is.

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

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/IndentHash)