
Use `Rails.root` IO methods instead of passing it to `File`.

`Rails.root` is an instance of `Pathname`
so we can apply many IO methods directly.

This cop works best when used together with
`Style/FileRead`, `Style/FileWrite` and `Rails/RootJoinChain`.

# Examples

```ruby
# bad
File.open(Rails.root.join('db', 'schema.rb'))
File.open(Rails.root.join('db', 'schema.rb'), 'w')
File.read(Rails.root.join('db', 'schema.rb'))
File.binread(Rails.root.join('db', 'schema.rb'))
File.write(Rails.root.join('db', 'schema.rb'), content)
File.binwrite(Rails.root.join('db', 'schema.rb'), content)
Dir.glob(Rails.root.join('db', 'schema.rb'))
Dir[Rails.root.join('db', 'schema.rb')]

# good
Rails.root.join('db', 'schema.rb').open
Rails.root.join('db', 'schema.rb').open('w')
Rails.root.join('db', 'schema.rb').read
Rails.root.join('db', 'schema.rb').binread
Rails.root.join('db', 'schema.rb').write(content)
Rails.root.join('db', 'schema.rb').binwrite(content)
Rails.root.glob("db/schema.rb")
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/RootPathnameMethods)