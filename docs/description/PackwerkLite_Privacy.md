
This cop helps ensure that packs are using public API of other systems
The following examples assume this basic setup.

# Examples

```ruby
# packs/bar/app/public/bar.rb
class Bar
  def my_public_api; end
end

# packs/bar/app/services/private.rb
class Private
  def my_private_api; end
end

# packs/bar/package.yml
# enforces_dependencies: false
# enforces_privacy: true

# bad
# packs/foo/app/services/foo.rb
class Foo
  def bar
    Private.my_private_api
  end
end

# good
# packs/foo/app/services/foo.rb
class Bar
  def bar
    Bar.my_public_api
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/PackwerkLite/Privacy)