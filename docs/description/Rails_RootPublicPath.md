
Favor `Rails.public_path` over `Rails.root` with `'public'`

# Examples

```ruby
# bad
Rails.root.join('public')
Rails.root.join('public/file.pdf')
Rails.root.join('public', 'file.pdf')

# good
Rails.public_path
Rails.public_path.join('file.pdf')
Rails.public_path.join('file.pdf')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RootPublicPath)