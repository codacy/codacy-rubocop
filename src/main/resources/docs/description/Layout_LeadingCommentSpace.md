
This cop checks whether comments have a leading space after the
`#` denoting the start of the comment. The leading space is not
required for some RDoc special syntax, like `#++`, `#--`,
`#:nodoc`, `=begin`- and `=end` comments, "shebang" directives,
or rackup options.

# Examples

```ruby

# bad
#Some comment

# good
# Some comment
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/LeadingCommentSpace)