
This cop is used to identify usages of file path joining process
to use `Rails.root.join` clause. It is used to add uniformity when
joining paths.

# Examples

```ruby
# bad
Rails.root.join('app/models/goober')
File.join(Rails.root, 'app/models/goober')
"#{Rails.root}/app/models/goober"

# good
Rails.root.join('app', 'models', 'goober')# bad
Rails.root.join('app', 'models', 'goober')
File.join(Rails.root, 'app/models/goober')
"#{Rails.root}/app/models/goober"

# good
Rails.root.join('app/models/goober')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FilePath)