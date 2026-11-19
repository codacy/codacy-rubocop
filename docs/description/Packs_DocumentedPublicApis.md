
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

# bad - RBS signatures and Sorbet annotations are not documentation
# packs/foo/app/public/foo.rb
class Foo
  # @override
  #: -> void
  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  # This is a documentation comment.
  # @override
  #: -> void
  def bar; end
end


# good
# packs/foo/app/public/foo.rb
class Foo
  private

  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  protected

  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  def self.bar; end
  private_class_method :bar
end

# bad - `private` does not apply to singleton methods, so `bar` is public
# packs/foo/app/public/foo.rb
class Foo
  private

  def self.bar; end
end


# bad
# packs/foo/app/public/foo.rb
class Foo
  private

  def bar; end
end

# bad
# packs/foo/app/public/foo.rb
class Foo
  protected

  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  private

  # This is a documentation comment.
  def bar; end
end

# good
# packs/foo/app/public/foo.rb
class Foo
  protected

  # This is a documentation comment.
  def bar; end
end


# good
# packs/foo/app/public/foo.rb
class Foo
  def method_missing(name, *args); end

  def respond_to_missing?(symbol, include_private); end
end

# bad
# packs/foo/app/public/foo.rb
class Foo
  def bar; end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packs/DocumentedPublicApis)