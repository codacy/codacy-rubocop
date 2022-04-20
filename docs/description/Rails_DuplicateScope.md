
This cop checks for multiple scopes in a model that have the same `where` clause. This
often means you copy/pasted a scope, updated the name, and forgot to change the condition.

# Examples

```ruby

# bad
scope :visible, -> { where(visible: true) }
scope :hidden, -> { where(visible: true) }

# good
scope :visible, -> { where(visible: true) }
scope :hidden, -> { where(visible: false) }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/DuplicateScope)