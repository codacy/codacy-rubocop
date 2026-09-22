
Checks for magic comments placed where Ruby silently ignores them.

The `encoding` magic comment is only honored on the first line of a file,
or on the second line when the first line is a shebang. Anywhere else it
is silently ignored - even directly below another comment or a blank line.

Other magic comments (such as `frozen_string_literal`) are honored
anywhere before the first token of code, but are ignored after any code,
with a warning emitted only when running Ruby with `-w`.

A magic comment misplaced ahead of a shebang also renders the shebang
ineffective, since a shebang is only recognized on the first line.

NOTE: An `encoding` comment that is only preceded by other magic
comments is not flagged by this cop; that case is handled by
`Lint/OrderedMagicComments`. `shareable_constant_value` is never
flagged, as Ruby intentionally allows it mid-file with block scoping.

# Examples

```ruby
# bad
# Documentation comment
# encoding: ascii-8bit
puts 'hello'

# good
# encoding: ascii-8bit
# Documentation comment
puts 'hello'

# bad
require 'foo'
# frozen_string_literal: true

# good
# frozen_string_literal: true
require 'foo'

# bad
# frozen_string_literal: true
#!/usr/bin/env ruby
puts 'hello'

# good
#!/usr/bin/env ruby
# frozen_string_literal: true
puts 'hello'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/MisplacedMagicComment)