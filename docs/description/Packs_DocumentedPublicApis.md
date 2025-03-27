
This cop helps ensure that each pack has a documented public API
The following examples assume this basic setup.

# Examples

```ruby

# bad
# packs/foo/app/public/foo.rb
class Foo
  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  # This is a documentation comment.
  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  # This is a documentation comment.
  # It should appear above a sorbet type signature
  sig { void }
  def bar; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packs/DocumentedPublicApis)