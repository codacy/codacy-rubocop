
This cop disallows the calls that are used to get constants fom Strings
such as +constantize+, +const_get+, and +constants+.

The goal of this cop is to make the code easier to statically analyze,
more IDE-friendly, and more predictable. It leads to code that clearly
expresses which values the constant can have.

# Examples

```ruby

# bad
class_name.constantize

# bad
constants.detect { |c| c.name == "User" }

# bad
const_get(class_name)

# good
case class_name
when "User"
  User
else
  raise ArgumentError
end

# good
{ "User" => User }.fetch(class_name)
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ConstantsFromStrings)