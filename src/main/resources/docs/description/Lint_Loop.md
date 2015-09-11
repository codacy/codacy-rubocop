##Loop

Checks if you are using a begin/end/while or begin/end/until statement and enforces you to change it to a loop/do/break statement


**Example:**

```
#Do this
loop do
 puts 'Hello World'
 x+=1
 break unless x < 5
end

#Instead of this
begin
  puts 'Hello World'
  x+=1
end while x < 0
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/Loop)
