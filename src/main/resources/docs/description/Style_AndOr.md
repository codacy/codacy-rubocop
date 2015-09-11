##And and Or replacement

Replace And and Or statements by && and || respectively since they don't provide additional
readability and the standart for the ruby language is && and ||

**Examples:**

```
#bad
if some_comdition and some_other_condition
end

#good
if some_condition && some_other_condition
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/AndOr)
