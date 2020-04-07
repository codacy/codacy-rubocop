
Here we check if the elements of a multi-line array literal are
aligned.

# Examples

```ruby
# good

array = [1, 2, 3,
         4, 5, 6]
array = ['run',
         'forrest',
         'run']

# bad

array = [1, 2, 3,
  4, 5, 6]
array = ['run',
     'forrest',
     'run']# good

array = [1, 2, 3,
  4, 5, 6]

# bad

array = [1, 2, 3,
         4, 5, 6]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/ArrayAlignment)