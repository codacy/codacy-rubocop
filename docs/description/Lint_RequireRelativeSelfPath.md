
Checks for uses a file requiring itself with `require_relative`.

# Examples

```ruby

# bad

# foo.rb
require_relative 'foo'
require_relative 'bar'

# good

# foo.rb
require_relative 'bar'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Lint/RequireRelativeSelfPath)