
This cop flags the `require` calls, from anywhere mapping to
the "lib" directory, except originating from lib/.

# Examples

```ruby

# bad
require "../lib/foo/bar"

# good
require "foo/bar"

# bad
require File.expand_path("../../lib/foo", __FILE__)

# good
require "foo"

# bad
require File.expand_path("../../../lib/foo/bar/baz/qux", __dir__)

# good
require "foo/bar/baz/qux"

# bad
require File.dirname(__FILE__) + "/../../lib/baz/qux"

# good
require "baz/qux"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packaging/RequireHardcodingLib)