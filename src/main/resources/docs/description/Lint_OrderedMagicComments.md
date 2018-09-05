
Checks the proper ordering of magic comments and whether
a magic comment is not placed before a shebang.

# Examples

```ruby
# bad

# frozen_string_literal: true
# encoding: ascii
p [''.frozen?, ''.encoding] #=> [true, #<Encoding:UTF-8>]

# good

# encoding: ascii
# frozen_string_literal: true
p [''.frozen?, ''.encoding] #=> [true, #<Encoding:US-ASCII>]

# good

#!/usr/bin/env ruby
# encoding: ascii
# frozen_string_literal: true
p [''.frozen?, ''.encoding] #=> [true, #<Encoding:US-ASCII>]
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/OrderedMagicComments)