
Checks for duplicate ``require``s and ``require_relative``s.

# Examples

```ruby
# bad
require 'foo'
require 'bar'
require 'foo'

# good
require 'foo'
require 'bar'

# good
require 'foo'
require_relative 'foo'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/DuplicateRequire)