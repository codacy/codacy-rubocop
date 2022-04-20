
This cop checks for the use of exit statements (namely `return`,
`break` and `throw`) in transactions. This is due to the eventual
unexpected behavior when using ActiveRecord >= 7, where transactions
exitted using these statements are being rollbacked rather than
committed (pre ActiveRecord 7 behavior).

As alternatives, it would be more intuitive to explicitly raise an
error when rollback is desired, and to use `next` when commit is
desired.

# Examples

```ruby
# bad
ApplicationRecord.transaction do
  return if user.active?
end

# bad
ApplicationRecord.transaction do
  break if user.active?
end

# bad
ApplicationRecord.transaction do
  throw if user.active?
end

# good
ApplicationRecord.transaction do
  # Rollback
  raise "User is active" if user.active?
end

# good
ApplicationRecord.transaction do
  # Commit
  next if user.active?
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/TransactionExitStatement)