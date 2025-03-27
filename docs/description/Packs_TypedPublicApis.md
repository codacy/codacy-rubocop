
This cop helps ensure that each pack's public API is strictly typed, enforcing strong boundaries.

# Examples

```ruby

# bad
# packs/foo/app/public/foo.rb
# typed: false
module Foo; end

# good
# packs/foo/app/public/foo.rb
# typed: strict
module Foo; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packs/TypedPublicApis)