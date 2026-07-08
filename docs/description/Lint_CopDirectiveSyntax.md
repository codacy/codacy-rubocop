
Checks that `# rubocop:enable ...` and `# rubocop:disable ...` statements
are strictly formatted.

A comment can be added to the directive by prefixing it with `--`.

# Examples

```ruby
# bad
# rubocop:disable Layout/LineLength Style/Encoding

# good
# rubocop:disable Layout/LineLength, Style/Encoding

# bad
# rubocop:disable

# good
# rubocop:disable all

# bad
# rubocop:disable Layout/LineLength # rubocop:disable Style/Encoding

# good
# rubocop:disable Layout/LineLength
# rubocop:disable Style/Encoding

# bad
# rubocop:wrongmode Layout/LineLength

# good
# rubocop:disable Layout/LineLength

# bad
# rubocop:disable Layout/LineLength comment

# good
# rubocop:disable Layout/LineLength -- comment
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/CopDirectiveSyntax)