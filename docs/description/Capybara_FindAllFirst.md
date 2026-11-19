
Enforces use of `first` instead of `all` with `first` or `[0]`.

# Examples

```ruby

# bad
all('a').first
all('a')[0]

# good
first('a')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/FindAllFirst)