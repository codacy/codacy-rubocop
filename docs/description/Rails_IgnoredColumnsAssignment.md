
Looks for assignments of `ignored_columns` that may override previous
assignments.

Overwriting previous assignments is usually a mistake, since it will
un-ignore the first set of columns. Since duplicate column names is not
a problem, it is better to simply append to the list.

# Examples

```ruby

# bad
class User < ActiveRecord::Base
  self.ignored_columns = [:one]
end

# bad
class User < ActiveRecord::Base
  self.ignored_columns = [:one, :two]
end

# good
class User < ActiveRecord::Base
  self.ignored_columns += [:one, :two]
end

# good
class User < ActiveRecord::Base
  self.ignored_columns += [:one]
  self.ignored_columns += [:two]
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/IgnoredColumnsAssignment)