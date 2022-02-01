
This cop verifies that a project contains Gemfile or gems.rb file and correct
associated lock file based on the configuration.

# Examples

```ruby
# bad
Project contains gems.rb and gems.locked files

# bad
Project contains Gemfile and gems.locked file

# good
Project contains Gemfile and Gemfile.lock# bad
Project contains Gemfile and Gemfile.lock files

# bad
Project contains gems.rb and Gemfile.lock file

# good
Project contains gems.rb and gems.locked files
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Bundler/GemFilename)