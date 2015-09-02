##Global Variables

Use module instances variables instead of global variables

**Example:**

```
# bad
$foo_bar = 1

# good
module Foo
  class << self
    attr_accessor :bar
  end
end
```