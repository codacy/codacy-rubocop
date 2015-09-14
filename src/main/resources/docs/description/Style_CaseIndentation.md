Indent when as deep as the case since it is the standart pattern for the ruby language

**Example:**

```
# bad
case
  when song.name == 'Misty'
    puts 'Not again!'
  when song.duration > 120
    puts 'Too long!'
  when Time.now.hour > 21
    puts "It's too late"
  else
    song.play
end

# good
case
when song.name == 'Misty'
  puts 'Not again!'
when song.duration > 120
  puts 'Too long!'
when Time.now.hour > 21
  puts "It's too late"
else
  song.play
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CaseIndentation)