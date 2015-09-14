Favor the use of sprintf and its alias format over the fairly cryptic String#% method.
We prefer format over sprintf because of the readability it provides.

**Example:**

```
# bad
'%d %d' % [20, 10]

format('%d %d', 20, 10)
 # or
format('%{first} %{second}', first: 20, second: 10)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FormatString)