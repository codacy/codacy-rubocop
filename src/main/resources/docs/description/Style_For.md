Do not use for keyword. Use each instead

**Example:**

```
# bad
for i in 0..5
   puts "Value of local variable is #{i}"
end

# good
(0..5).each do |i|
   puts "Value of local variable is #{i}"
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/For)