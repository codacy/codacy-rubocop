
Ensures that callback conditionals are bound to the right type
so that they are type checked properly.

Auto-correction is unsafe because other libraries define similar style callbacks as Rails, but don't always need
binding to the attached class. Auto-correcting those usages can lead to false positives and auto-correction
introduces new typing errors.

# Examples

```ruby

# bad
class Post < ApplicationRecord
  before_create :do_it, if: -> { should_do_it? }

  def should_do_it?
    true
  end
end

# good
class Post < ApplicationRecord
  before_create :do_it, if: -> {
    T.bind(self, Post)
    should_do_it?
  }

  def should_do_it?
    true
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/CallbackConditionalsBinding)