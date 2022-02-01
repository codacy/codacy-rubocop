
Favor `File.(bin)read` convenience methods.

# Examples

```ruby
## text mode
# bad
File.open(filename).read
File.open(filename, &:read)
File.open(filename) { |f| f.read }
File.open(filename) do |f|
  f.read
end
File.open(filename, 'r').read
File.open(filename, 'r', &:read)
File.open(filename, 'r') do |f|
  f.read
end

# good
File.read(filename)## binary mode
# bad
File.open(filename, 'rb').read
File.open(filename, 'rb', &:read)
File.open(filename, 'rb') do |f|
  f.read
end

# good
File.binread(filename)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/FileRead)