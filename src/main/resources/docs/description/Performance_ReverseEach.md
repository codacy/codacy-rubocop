##Reverse_each vs reverse.each

Reverse_each is definitely faster and it has to do with the time associating the creating the reverse array
So it is better to change the reverse.each to reverse_each

**Examples**

```
#bad
[].reverse.each

#good
[].reverse_each
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ReverseEach)
