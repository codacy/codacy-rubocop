
Checks whether comments have a leading space after the
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
# bad

#**
# Some comment
# Another line of comment
#*
# good

#**
# Some comment
# Another line of comment
#*
# bad

#ruby=2.7.0
#ruby-gemset=myproject
# good

#ruby=2.7.0
#ruby-gemset=myproject
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/LeadingCommentSpace)