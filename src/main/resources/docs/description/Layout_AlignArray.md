
Here we check if the elements of a multi-line array literal are
aligned.

# Examples

```ruby
# bad
a = [1, 2, 3,
  4, 5, 6]
array = ['run',
     'forrest',
     'run']

# good
a = [1, 2, 3,
     4, 5, 6]
a = ['run',
     'forrest',
     'run']
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/AlignArray)