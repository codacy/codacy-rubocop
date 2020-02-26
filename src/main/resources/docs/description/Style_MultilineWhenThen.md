
This cop checks uses of the `then` keyword
in multi-line when statements.

# Examples

```ruby
# bad
case foo
when bar then
end

# good
case foo
when bar
end

# good
case foo
when bar then do_something
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MultilineWhenThen)