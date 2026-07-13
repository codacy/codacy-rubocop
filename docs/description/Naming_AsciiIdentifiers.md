
Checks for non-ascii characters in identifier and constant names.
Identifiers are always checked and whether constants are checked
can be controlled using AsciiConstants config.

# Examples

```ruby
# bad
def καλημερα # Greek alphabet (non-ascii)
end

# bad
def こんにちはと言う # Japanese character (non-ascii)
end

# bad
def hello_🍣 # Emoji (non-ascii)
end

# good
def say_hello
end

# bad
신장 = 10 # Hangul character (non-ascii)

# good
height = 10

# bad
params[:عرض_gteq] # Arabic character (non-ascii)

# good
params[:width_gteq]

# bad
class Foö
end

FOÖ = "foo"

# good
class Foö
end

FOÖ = "foo"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/AsciiIdentifiers)