
Checks for overriding built-in Active Record methods instead of using
callbacks.

# Examples

```ruby
# bad
class Book < ApplicationRecord
  def save
    self.title = title.upcase!
    super
  end
end

# good
class Book < ApplicationRecord
  before_save :upcase_title

  def upcase_title
    self.title = title.upcase!
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ActiveRecordOverride)