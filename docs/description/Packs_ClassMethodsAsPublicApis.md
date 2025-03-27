
This cop states that public API should live on class methods, which are more easily statically analyzable,
searchable, and typically hold less state.

Options:

* `AcceptableParentClasses`: A list of classes that, if inherited from, non-class methods are permitted (useful when value objects are a part of your public API)
* `AcceptableMixins`: A list of modules that, if included, non-class methods are permitted

# Examples

```ruby

# bad
# packs/foo/app/public/foo.rb
module Foo
  def blah
  end
end

# good
# packs/foo/app/public/foo.rb
module Foo
  def self.blah
  end
end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packs/ClassMethodsAsPublicApis)