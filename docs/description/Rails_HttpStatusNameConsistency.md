
Enforces consistency by using the current HTTP status names.

# Examples

```ruby
# bad
render json: { error: "Invalid data" }, status: :unprocessable_entity
head :payload_too_large

# good
render json: { error: "Invalid data" }, status: :unprocessable_content
head :content_too_large
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/HttpStatusNameConsistency)