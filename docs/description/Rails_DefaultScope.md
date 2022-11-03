
Looks for uses of `default_scope`.

# Examples

```ruby
# bad
default_scope -> { where(hidden: false) }

# good
scope :published, -> { where(hidden: false) }

# bad
def self.default_scope
  where(hidden: false)
end

# good
def self.published
  where(hidden: false)
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DefaultScope)