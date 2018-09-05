
This cop checks empty comment.

# Examples

```ruby
# bad

#
class Foo
end

# good

#
# Description of `Foo` class.
#
class Foo
end# good

def foo
end

#################

def bar
end# bad

def foo
end

#################

def bar
end# good

#
# Description of `Foo` class.
#
class Foo
end# bad

#
# Description of `Foo` class.
#
class Foo
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/EmptyComment)