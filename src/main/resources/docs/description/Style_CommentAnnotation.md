
This cop checks that comment annotation keywords are written according
to guidelines.

# Examples

```ruby
# bad
# TODO make better

# good
# TODO: make better

# bad
# TODO:make better

# good
# TODO: make better

# bad
# fixme: does not work

# good
# FIXME: does not work

# bad
# Optimize does not work

# good
# OPTIMIZE: does not work
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CommentAnnotation)