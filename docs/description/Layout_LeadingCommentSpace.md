
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
# bad

include Enumerable #[Integer]

attr_reader :name #: String
attr_reader :age  #: Integer?

#: (
#|   Integer,
#|   String
#| ) -> void
def foo; end
# good

include Enumerable #[Integer]

attr_reader :name #: String
attr_reader :age  #: Integer?

#: (
#|   Integer,
#|   String
#| ) -> void
def foo; end
# bad
[1, 2, 3].each_with_object([]) do |n, list| #$ Array[Integer]
  list << n
end

name = 'John'      #: String
# good

[1, 2, 3].each_with_object([]) do |n, list| #$ Array[Integer]
  list << n
end

name = 'John'      #: String
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/LeadingCommentSpace)