
Checks legacy syntax usage of `tag`

NOTE: Allow `tag` when the first argument is a variable because
`tag(name)` is simpler rather than `tag.public_send(name)`.
And this cop will be renamed to something like `LegacyTag` in the future. (e.g. RuboCop Rails 3.0)

# Examples

```ruby
# bad
tag(:p)
tag(:br, class: 'classname')

# good
tag.p
tag.br(class: 'classname')
tag(name, class: 'classname')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/ContentTag)