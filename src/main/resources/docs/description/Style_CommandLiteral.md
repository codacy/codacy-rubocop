
This cop enforces using `` or %x around command literals.

# Examples

```ruby
# bad
folders = %x(find . -type d).split

# bad
%x(
  ln -s foo.example.yml foo.example
  ln -s bar.example.yml bar.example
)

# good
folders = `find . -type d`.split

# good
`
  ln -s foo.example.yml foo.example
  ln -s bar.example.yml bar.example
`# bad
folders = %x(find . -type d).split

# bad
`
  ln -s foo.example.yml foo.example
  ln -s bar.example.yml bar.example
`

# good
folders = `find . -type d`.split

# good
%x(
  ln -s foo.example.yml foo.example
  ln -s bar.example.yml bar.example
)# bad
folders = `find . -type d`.split

# bad
`
  ln -s foo.example.yml foo.example
  ln -s bar.example.yml bar.example
`

# good
folders = %x(find . -type d).split

# good
%x(
  ln -s foo.example.yml foo.example
  ln -s bar.example.yml bar.example
)# If `false`, the cop will always recommend using `%x` if one or more
# backticks are found in the command string.

# bad
`echo \`ls\``

# good
%x(echo `ls`)# good
`echo \`ls\``
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Style/CommandLiteral)