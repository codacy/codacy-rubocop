
Checks for duplicated magic comments.

# Examples

```ruby

# bad

# encoding: ascii
# encoding: ascii

# good

# encoding: ascii

# bad

# frozen_string_literal: true
# frozen_string_literal: true

# good

# frozen_string_literal: true
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateMagicComment)