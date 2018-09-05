
This cop makes sure that Ruby source files have snake_case
names. Ruby scripts (i.e. source files with a shebang in the
first line) are ignored.

# Examples

```ruby
# bad
lib/layoutManager.rb

anything/usingCamelCase

# good
lib/layout_manager.rb

anything/using_snake_case.rake
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Naming/FileName)