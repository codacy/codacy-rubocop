
Favor the logger.<level>_with_data method for structured logging.

# Examples

```ruby
# bad - string interpolations exceed the threshold (configurable via AllowedStringInterpolations setting)
Rails.logger.info("a message with more than 2 interpolations: #{foo} #{bar} #{baz}")

# bad - string interpolation contains Enumerable methods (:map, :collect)
Rails.logger.info("Deleted the following records: #{records.map(&:id)}")

# good
Rails.logger.info("a message")

# good - string interpolations are within the threshold (configurable via AllowedStringInterpolations setting)
Rails.logger.info("a message with 2 interpolations: #{foo} #{bar}")

# good
Rails.logger.info_with_data("Created the record", record_id: record.id, status: status)

# good
Rails.logger.info_with_data("Deleted the following records", record_ids: results.records.map(&:id))
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Mdsol/LogWithData)