
Use `next` to skip iteration instead of a condition at the end.

# Examples

```ruby
# bad
[1, 2].each do |a|
  if a == 1
    puts a
  end
end

# good
[1, 2].each do |a|
  next unless a == 1
  puts a
end

# good
[1, 2].each do |a|
  puts a if a == 1
end# With `always` all conditions at the end of an iteration needs to be
# replaced by next - with `skip_modifier_ifs` the modifier if like
# this one are ignored: `[1, 2].each { |a| puts a if a == 1 }`

# bad
[1, 2].each do |a|
  puts a if a == 1
end

# bad
[1, 2].each do |a|
  if a == 1
    puts a
  end
end

# good
[1, 2].each do |a|
  next unless a == 1
  puts a
end# bad
[1, 2].each do |a|
  if a == 1
    puts a
  end
  if a == 2
    puts a
  end
end

# good
[1, 2].each do |a|
  if a == 1
    puts a
  end
  next unless a == 2
  puts a
end# good
[1, 2].each do |a|
  if a == 1
    puts a
  end
  if a == 2
    puts a
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/Next)