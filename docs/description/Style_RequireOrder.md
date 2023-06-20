
Sort `require` and `require_relative` in alphabetical order.

# Examples

```ruby
# bad
require 'b'
require 'a'

# good
require 'a'
require 'b'

# bad
require_relative 'b'
require_relative 'a'

# good
require_relative 'a'
require_relative 'b'

# good (sorted within each section separated by a blank line)
require 'a'
require 'd'

require 'b'
require 'c'

# good
require 'b'
require_relative 'c'
require 'a'

# bad
require 'a'
require 'c' if foo
require 'b'

# good
require 'a'
require 'b'
require 'c' if foo

# bad
require 'c'
if foo
  require 'd'
  require 'b'
end
require 'a'

# good
require 'c'
if foo
  require 'b'
  require 'd'
end
require 'a'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RequireOrder)