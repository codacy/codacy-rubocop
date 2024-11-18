
Checks for the use of exit statements (namely `return`,
`break` and `throw`) in transactions. This is due to the eventual
unexpected behavior when using ActiveRecord >= 7, where transactions
exited using these statements are being rollbacked rather than
committed (pre ActiveRecord 7 behavior).

As alternatives, it would be more intuitive to explicitly raise an
error when rollback is desired, and to use `next` when commit is
desired.

If you are defining custom transaction methods, you can configure it with `TransactionMethods`.

NOTE: This cop is disabled on Rails >= 7.2 because transactions were restored
to their historical behavior. In Rails 7.1, the behavior is controlled with
the config `active_record.commit_transaction_on_non_local_return`.

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

# bad, as `with_lock` implicitly opens a transaction too
user.with_lock do
  throw if user.active?
end

# bad, as `with_lock` implicitly opens a transaction too
ApplicationRecord.with_lock do
  break if user.active?
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
end# bad
CustomModel.custom_transaction do
  return if user.active?
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/TransactionExitStatement)