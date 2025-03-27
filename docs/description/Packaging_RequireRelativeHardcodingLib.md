
This cop flags the `require_relative` calls, from anywhere
mapping to the "lib" directory, except originating from lib/ or
the gemspec file, and suggests to use `require` instead.

# Examples

```ruby

# bad
require_relative "lib/foo"

# good
require "foo"

# bad
require_relative "../../lib/foo/bar"

# good
require "foo/bar"

# good
require_relative "foo/bar/bax"
require_relative "baz/qux"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packaging/RequireRelativeHardcodingLib)