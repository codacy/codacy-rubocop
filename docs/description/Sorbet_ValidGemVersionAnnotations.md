
Checks that gem versions in RBI annotations are properly formatted per the Bundler gem specification.

# Examples

```ruby
# bad
# @version > not a version number

# good
# @version = 1

# good
# @version > 1.2.3

# good
# @version <= 4.3-preview
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Sorbet/ValidGemVersionAnnotations)