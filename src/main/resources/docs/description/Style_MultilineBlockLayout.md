##Multiline Block Layout

When using multiline blocks always use the same layout specified below

**Example:**

```
# bad
blah do |i| foo(i)
  bar(i)
end

# bad
blah do
  |i| foo(i)
  bar(i)
end

# good
blah do |i|
  foo(i)
  bar(i)
end

# bad
blah { |i| foo(i)
  bar(i)
}

# good
blah { |i|
  foo(i)
  bar(i)
}
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineBlockLayout)
