
When you define a uniqueness validation in Active Record model,
you also should add a unique index for the column. There are two reasons
First, duplicated records may occur even if Active Record's validation
is defined.
Second, it will cause slow queries. The validation executes a `SELECT`
statement with the target column when inserting/updating a record.
If the column does not have an index and the table is large,
the query will be heavy.

Note that the cop does nothing if db/schema.rb does not exist.

# Examples

```ruby
# bad - if the schema does not have a unique index
validates :account, uniqueness: true

# good - if the schema has a unique index
validates :account, uniqueness: true

# good - even if the schema does not have a unique index
validates :account, length: { minimum: MIN_LENGTH }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UniqueValidationWithoutIndex)