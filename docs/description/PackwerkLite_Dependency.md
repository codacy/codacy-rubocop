
This cop helps ensure that packs are depending on packs explicitly.

# Examples

```ruby

# bad
# packs/foo/app/services/foo.rb
class Foo
  def bar
    Bar
  end
end

# packs/foo/package.yml
# enforces_dependencies: true
# enforces_privacy: false
# dependencies:
#   - packs/baz

# good
# packs/foo/app/services/foo.rb
class Foo
  def bar
    Bar
  end
end

# packs/foo/package.yml
# enforces_dependencies: true
# enforces_privacy: false
# dependencies:
#   - packs/baz
#   - packs/bar
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/PackwerkLite/Dependency)