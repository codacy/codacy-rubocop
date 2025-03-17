
Checks for `map { |id| [id] }` and suggests replacing it with `zip`.

# Examples

```ruby
# bad
[1, 2, 3].map { |id| [id] }

# good
[1, 2, 3].zip
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Performance/ZipWithoutBlock)