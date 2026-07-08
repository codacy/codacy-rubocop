
Checks if empty lines around the bodies of blocks match
the configuration.

# Examples

```ruby
# bad
foo do |bar|

  # ...

end

# good
foo do |bar|
  # ...
end# bad
foo do |bar|
  # ...
end

# good
foo do |bar|

  # ...

end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLinesAroundBlockBody)