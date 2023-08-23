
Identifies usages of file path joining process to use `Rails.root.join` clause.
It is used to add uniformity when joining paths.

# Examples

```ruby
# bad
Rails.root.join('app', 'models', 'goober')

# good
Rails.root.join('app/models/goober')

# bad
File.join(Rails.root, 'app/models/goober')
"#{Rails.root}/app/models/goober"

# good
Rails.root.join('app/models/goober').to_s# bad
Rails.root.join('app/models/goober')

# good
Rails.root.join('app', 'models', 'goober')

# bad
File.join(Rails.root, 'app/models/goober')
"#{Rails.root}/app/models/goober"

# good
Rails.root.join('app', 'models', 'goober').to_s
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Rails/FilePath)