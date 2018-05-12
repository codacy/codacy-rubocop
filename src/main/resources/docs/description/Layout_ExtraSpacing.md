
This cop checks for extra/unnecessary whitespace.

# Examples

```ruby

# good if AllowForAlignment is true
name      = "RuboCop"
# Some comment and an empty line

website  += "/bbatsov/rubocop" unless cond
puts        "rubocop"          if     debug

# bad for any configuration
set_app("RuboCop")
website  = "https://github.com/bbatsov/rubocop"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/ExtraSpacing)