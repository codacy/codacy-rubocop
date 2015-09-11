##Bare Percent Literals Usage

Use Bare Percent Literals(%()) instead of %Q() since it is a more clean way of doing the exact same thing

**Example:**

```
#bad
%Q(This is #{quality} test)

#good
%(This is #{quality} test)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/BarePercentLiterals)
