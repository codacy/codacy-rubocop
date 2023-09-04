
Checks for a redundant argument passed to certain methods.

NOTE: This cop is limited to methods with single parameter.

Method names and their redundant arguments can be configured like this:

[source,yaml]
----
Methods:
  join: ''
  sum: 0
  split: ' '
  chomp: "\n"
  chomp!: "\n"
  foo: 2
----

# Examples

```ruby
# bad
array.join('')
[1, 2, 3].join("")
array.sum(0)
exit(true)
exit!(false)
string.split(" ")
"first\nsecond".split(" ")
string.chomp("\n")
string.chomp!("\n")
A.foo(2)

# good
array.join
[1, 2, 3].join
array.sum
exit
exit!
string.split
"first second".split
string.chomp
string.chomp!
A.foo
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantArgument)