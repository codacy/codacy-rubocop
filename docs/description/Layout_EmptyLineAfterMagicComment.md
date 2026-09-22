
Checks for a newline after the final magic comment.

`NumberOfEmptyLines` configures the minimum number of empty lines required. Set it
to `2` when using YARD, which otherwise treats the magic comments as documentation
for the first module or class in the file.

NOTE: `Layout/EmptyLines` has to be disabled for values greater than `1`, as it
removes the extra empty lines this cop adds, and autocorrecting with both enabled
loops between them.

# Examples

```ruby
# good
# frozen_string_literal: true

# Some documentation for Person
class Person
  # Some code
end

# bad
# frozen_string_literal: true
# Some documentation for Person
class Person
  # Some code
end

# good
# frozen_string_literal: true

class Person
end

# bad
# frozen_string_literal: true

class Person
end

# good
# frozen_string_literal: true

class Person
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyLineAfterMagicComment)