
Enforces use of `first` instead of `all` with `first` or `[0]`.

# Examples

```ruby

# bad
all('a').first
all('a')[0]
find('a', match: :first)
all('a', match: :first)

# good
first('a')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Capybara/FindAllFirst)