
If you try to render content along with a non-content status code (100-199, 204, 205, or 304),
it will be dropped from the response.

This cop checks for uses of `render` which specify both body content and a non-content status.

# Examples

```ruby
# bad
render 'foo', status: :continue
render status: 100, plain: 'Ruby!'

# good
head :continue
head 100
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/UnusedRenderContent)