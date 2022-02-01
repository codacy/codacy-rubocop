
Since Rails 5.0 the default for `belongs_to` is `optional: false`
unless `config.active_record.belongs_to_required_by_default` is
explicitly set to `false`. The presence validator is added
automatically, and explicit presence validation is redundant.

# Examples

```ruby
# bad
belongs_to :user
validates :user, presence: true

# bad
belongs_to :user
validates :user_id, presence: true

# bad
belongs_to :author, foreign_key: :user_id
validates :user_id, presence: true

# good
belongs_to :user

# good
belongs_to :author, foreign_key: :user_id
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RedundantPresenceValidationOnBelongsTo)