
This cop checks that `tag` is used instead of `content_tag`
because `content_tag` is legacy syntax.

NOTE: Allow `content_tag` when the first argument is a variable because
     `content_tag(name)` is simpler rather than `tag.public_send(name)`.

# Examples

```ruby
# bad
content_tag(:p, 'Hello world!')
content_tag(:br)

# good
tag.p('Hello world!')
tag.br
content_tag(name, 'Hello world!')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ContentTag)