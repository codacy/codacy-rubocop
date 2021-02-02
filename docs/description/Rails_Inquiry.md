
This cop checks that Active Support's `inquiry` method is not used.

# Examples

```ruby
# bad - String#inquiry
ruby = 'two'.inquiry
ruby.two?

# good
ruby = 'two'
ruby == 'two'

# bad - Array#inquiry
pets = %w(cat dog).inquiry
pets.gopher?

# good
pets = %w(cat dog)
pets.include? 'cat'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/Inquiry)