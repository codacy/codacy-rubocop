
Checks that block braces have or don't have surrounding space inside
them on configuration. For blocks taking parameters, it checks that the
left brace has or doesn't have trailing space depending on
configuration.

# Examples

```ruby
# The `space` style enforces that block braces have
# surrounding space.

# bad
some_array.each {puts e}

# good
some_array.each { puts e }# The `no_space` style enforces that block braces don't
# have surrounding space.

# bad
some_array.each { puts e }

# good
some_array.each {puts e}# The `no_space` EnforcedStyleForEmptyBraces style enforces that
# block braces don't have a space in between when empty.

# bad
some_array.each {   }
some_array.each {  }
some_array.each { }

# good
some_array.each {}# The `space` EnforcedStyleForEmptyBraces style enforces that
# block braces have at least a space in between when empty.

# bad
some_array.each {}

# good
some_array.each { }
some_array.each {  }
some_array.each {   }# The SpaceBeforeBlockParameters style set to `true` enforces that
# there is a space between `{` and `|`. Overrides `EnforcedStyle`
# if there is a conflict.

# bad
[1, 2, 3].each {|n| n * 2 }

# good
[1, 2, 3].each { |n| n * 2 }# The SpaceBeforeBlockParameters style set to `false` enforces that
# there is no space between `{` and `|`. Overrides `EnforcedStyle`
# if there is a conflict.

# bad
[1, 2, 3].each { |n| n * 2 }

# good
[1, 2, 3].each {|n| n * 2 }
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Layout/SpaceInsideBlockBraces)