
Checks the spacing around the keywords.

# Examples

```ruby

# bad
something 'test'do|x|
end

while(something)
end

something = 123if test

# good
something 'test' do |x|
end

while (something)
end

something = 123 if test
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceAroundKeyword)