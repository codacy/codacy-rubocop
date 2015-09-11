##Command Literals

Choose one type of command literal and use it in all the code you have

**Backticks:**

```
folders = 'find . -type d'.split
```

**Percent_x:**

```
folders = %x(find . -type d).split
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CommandLiteral)
