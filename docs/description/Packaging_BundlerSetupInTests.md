
This cop flags the `require "bundler/setup"` calls if they're
made from inside the tests directory.

# Examples

```ruby

# bad
require "foo"
require "bundler/setup"

# good
require "foo"
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packaging/BundlerSetupInTests)