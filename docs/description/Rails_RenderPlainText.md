
Identifies places where `render text:` can be
replaced with `render plain:`.

# Examples

```ruby
# bad - explicit MIME type to `text/plain`
render text: 'Ruby!', content_type: 'text/plain'

# good - short and precise
render plain: 'Ruby!'

# good - explicit MIME type not to `text/plain`
render text: 'Ruby!', content_type: 'text/html'# good - sets MIME type to `text/html`
render text: 'Ruby!'# bad - sets MIME type to `text/html`
render text: 'Ruby!'
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RenderPlainText)