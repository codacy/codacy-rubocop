
Use a single `#join` instead of chaining on `Rails.root` or `Rails.public_path`.

# Examples

```ruby
# bad
Rails.root.join('db').join('schema.rb')
Rails.root.join('db').join(migrate).join('migration.rb')
Rails.public_path.join('path').join('file.pdf')
Rails.public_path.join('path').join(to).join('file.pdf')

# good
Rails.root.join('db', 'schema.rb')
Rails.root.join('db', migrate, 'migration.rb')
Rails.public_path.join('path', 'file.pdf')
Rails.public_path.join('path', to, 'file.pdf')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RootJoinChain)