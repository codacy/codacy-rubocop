
Prefer to use `File.empty?('path/to/file')` when checking if a file is empty.

# Examples

```ruby
# bad
File.zero?('path/to/file')
File.size('path/to/file') == 0
File.size('path/to/file') >= 0
File.size('path/to/file').zero?
File.read('path/to/file').empty?
File.binread('path/to/file') == ''
FileTest.zero?('path/to/file')

# good
File.empty?('path/to/file')
FileTest.empty?('path/to/file')
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FileEmpty)