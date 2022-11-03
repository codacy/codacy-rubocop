
Ensures magic comments are written consistently throughout your code base.
Looks for discrepancies in separators (`-` vs `_`) and capitalization for
both magic comment directives and values.

Required capitalization can be set with the `DirectiveCapitalization` and
`ValueCapitalization` configuration keys.

NOTE: If one of these configuration is set to nil, any capitalization is allowed.

# Examples

```ruby
# The `snake_case` style will enforce that the frozen string literal
# comment is written in snake case. (Words separated by underscores)
# bad
# frozen-string-literal: true

module Bar
  # ...
end

# good
# frozen_string_literal: false

module Bar
  # ...
end# The `kebab_case` style will enforce that the frozen string literal
# comment is written in kebab case. (Words separated by hyphens)
# bad
# frozen_string_literal: true

module Baz
  # ...
end

# good
# frozen-string-literal: true

module Baz
  # ...
end# bad
# FROZEN-STRING-LITERAL: true

# good
# frozen-string-literal: true# bad
# frozen-string-literal: true

# good
# FROZEN-STRING-LITERAL: true# any capitalization is accepted

# good
# frozen-string-literal: true

# good
# FROZEN-STRING-LITERAL: true# any capitalization is accepted

# good
# frozen-string-literal: true

# good
# frozen-string-literal: TRUE# when a value is not given, any capitalization is accepted

# bad
# frozen-string-literal: TRUE

# good
# frozen-string-literal: TRUE# bad
# frozen-string-literal: true

# good
# frozen-string-literal: TRUE
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/MagicCommentFormat)