
This cop checks whether constant value isn't relative date.
Because the relative date will be evaluated only once.

# Examples

```ruby
# bad
class SomeClass
  EXPIRED_AT = 1.week.since
end

# good
class SomeClass
  def self.expired_at
    1.week.since
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RelativeDateConstant)