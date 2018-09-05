
This cops checks if empty lines around the bodies of blocks match
the configuration.

# Examples

```ruby
# good

foo do |bar|

  # ...

end# good

foo do |bar|
  # ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundBlockBody)