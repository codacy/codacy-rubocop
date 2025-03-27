
This cop helps ensure that each pack exposes one namespace.
Note that this cop doesn't necessarily expect you to be using packs-rails (https://github.com/rubyatscale/packs-rails),
but it does expect packs to live in the organizational structure as described in the README.md of that gem.

This allows packs to opt in and also prevent *other* files from sitting in their namespace.

# Examples

```ruby

# bad
# packs/foo/app/services/blah/bar.rb
class Blah::Bar; end

# good
# packs/foo/app/services/foo/blah/bar.rb
class Foo::Blah::Bar; end
```

[Source](http://www.rubydoc.info/gems/rubocop/RuboCop/Cop/Packs/RootNamespaceIsPackName)