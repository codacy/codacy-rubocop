
Checks the spacing around the keywords.

# Examples

```ruby

# bad
something 'test'do|x|
end

while(something)
end

something = 123if test

return(foo + bar)

# good
something 'test' do |x|
end

while (something)
end

something = 123 if test

return (foo + bar)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAroundKeyword)