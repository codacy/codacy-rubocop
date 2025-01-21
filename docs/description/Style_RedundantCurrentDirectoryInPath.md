
Checks for paths given to `require_relative` that start with
the current directory (`./`), which can be omitted.

# Examples

```ruby

# bad
require_relative './path/to/feature'

# good
require_relative 'path/to/feature'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/RedundantCurrentDirectoryInPath)