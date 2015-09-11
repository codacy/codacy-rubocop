##Module function

You should always use ```module_function`` instead of ```extend self```

**Example:**

```
# bad
module Foo
  extend self

  ...
end

# good
module Foo
  module_function

  ...
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/ModuleFunction)
